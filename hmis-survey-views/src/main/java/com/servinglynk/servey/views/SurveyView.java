package com.servinglynk.servey.views;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.servinglynk.hive.connection.HiveConnection;
import com.servinglynk.hive.connection.ViewQuery;
import com.servinglynk.hmis.warehouse.Properties;
public class SurveyView extends BaseView {	
    
	/***
	 * Get existings submissions so we don't insert them again.
	 * @param projectGroupCode
	 * @param tableName
	 * @return
	 */
	public static Map<String,String> getExisingSubmissions(String projectGroupCode,String tableName) {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		Map<String,String> hiveSubmissions = new HashMap<>();
		try {
			connection = HiveConnection.getConnection();
			// execute statement
				StringBuilder builder = new StringBuilder();
				builder.append("select client_id client,submission_id submission from ");
				builder.append(projectGroupCode);
				builder.append(".");
				builder.append(tableName);
				statement = connection.prepareStatement(builder.toString());
				resultSet = statement.executeQuery();
				while(resultSet.next()) {
					String clientId = resultSet.getString("client");
					String submissionId = resultSet.getString("submission");
					hiveSubmissions.put(submissionId, clientId);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hiveSubmissions;
	}
    public static void createHiveTableForSurvey(String projectGroupCode) throws Exception {
    	// Get distinct questions for a survey.
    	List<String> disinctSurveys = getDisinctSurveys("survey");
    	for(String surveyId : disinctSurveys) {
    		List<String> disinctQuestions = getDisinctQuestions("survey", UUID.fromString(surveyId));
    		//System.out.println("Quesitons for survey ::"+surveyId+ "  are ::"+disinctQuestions.toString());
    		// Get the Survey details from the survey table and project group code in the survey 
    		Survey survey = getSurveyById("survey", surveyId);
    		// TODO: Below items
    		String tableName  = survey.getSurveyName().replaceAll("[^a-zA-Z0-9]", "_");
    		if(StringUtils.equalsIgnoreCase(survey.getProjectGroupCode(), projectGroupCode)) {
    	   		createHiveTable(survey, disinctQuestions);
            	//  create a hive table after getting the questions.    	
            	//Insert the data into the view by clientIds and submission id.
        		// Get unique clients for a survey.
    	   		Map<String, String> exisingSubmissions = getExisingSubmissions(projectGroupCode, tableName);
        		List<String>  clients = getClientsForSurvey("survey", UUID.fromString(surveyId));
        		for(String clientId : clients) {
        			if(StringUtils.isNotBlank(clientId)) {
        				List<Response>  responses = getResponseBySubmissionClient("survey", UUID.fromString(surveyId),UUID.fromString(clientId));
                		insertIntoHiveTable(survey,disinctQuestions, responses,clientId,exisingSubmissions);
        			}
        		}	
    		}
        	// table is the hive database where this hive table needs to be created.
 
    	}
    }
    
    private static List<String> getClientsForSurvey(String schema,
			UUID surveyId) throws Exception {
    	 List<String> clientIds = new ArrayList<>();
         ResultSet resultSet = null;
         PreparedStatement statement = null;
         Connection connection = null;
         try{
             connection = getConnection();
             statement = connection.prepareStatement(ViewQuery.GET_DISTICNT_CLIENT_FOR_SURVEY);
             statement.setObject(1, surveyId);
             resultSet = statement.executeQuery();
             while (resultSet.next()){
            	 clientIds.add(resultSet.getString("client_id"));
             }

         }catch (Exception ex){
             throw ex;
         }
         return clientIds;
	}

	public static void insertIntoHiveTable(Survey survey, List<String> disinctQuestions, List<Response>  responses,String clientId, Map<String,String> existingSubmissions) {
    	Connection connection;
		try {
			connection = HiveConnection.getConnection();
	      // execute statement
		 int i = 4;
		 Map<String,Integer> questionMap = new HashMap<String, Integer>();
			StringBuilder builder = new StringBuilder();
		 	builder.append("INSERT INTO ");
		 	String tableName  = survey.getSurveyName().replaceAll("[^a-zA-Z0-9]", "_");
		 	builder.append(survey.getProjectGroupCode()+"."+tableName);
			builder.append("  VALUES ( ");
			builder.append("?, ?, ?");
			  int count = 4;
			  for(String question : disinctQuestions) {
				  questionMap.put(question, count);
				  count ++;
				  builder.append(",?");  
			  }
			  builder.append(")");
			  
			  PreparedStatement preparedStatement = connection.prepareStatement(builder.toString());
			  preparedStatement.setString(1, clientId);
			  preparedStatement.setString(2, String.valueOf(survey.getSurveyDate()));
			  for(int loopCount=3; loopCount<= count; loopCount++) {
				  preparedStatement.setString(loopCount, "");  
			  }
			  String submissionId = null;
			  boolean resonseContainMoreThanOneClient = false;
			  boolean clientWithSubmissionExist =false;
		 for (Response response : responses) {
			 	  String client = existingSubmissions.get(response.getSubmissionId());
			 	  if(StringUtils.isBlank(client)) {
			 		 preparedStatement.setString(3, response.getSubmissionId());
					  preparedStatement.setString(questionMap.get(response.getQuestionId()), response.getResponseText() !=null ?  response.getResponseText() : "");
					  // execute insert SQL stetement
					  boolean containsOnlyOneColumn = false;
					  if(CollectionUtils.isNotEmpty(disinctQuestions) &&  disinctQuestions.size()==1) {
						  preparedStatement.executeUpdate();
						  containsOnlyOneColumn = true;
						  i =4;
					  }
					  if(submissionId !=null && !StringUtils.equals(submissionId, response.getSubmissionId()) && !containsOnlyOneColumn) {
						 // System.out.println("Insert query metadata:::"+preparedStatement.getParameterMetaData().toString());
						  System.out.println("The Query:::"+builder.toString());
						  System.out.println("Inserting records for :::"+survey.getProjectGroupCode()+"."+tableName);
						  preparedStatement.executeUpdate();
						  resonseContainMoreThanOneClient = true;
						  i =4;
			 	    }
				  }else {
					  clientWithSubmissionExist = true;
				  }
		       submissionId = response.getSubmissionId();
		 }
		 if(!resonseContainMoreThanOneClient && !clientWithSubmissionExist) {
			 System.out.println("The Query:::"+builder.toString());
			 System.out.println("Inserting records for :::"+survey.getProjectGroupCode()+"."+tableName);
			  preparedStatement.executeUpdate();
		 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error inserting into "+survey.getProjectGroupCode()+"."+survey.getSurveyName().replaceAll("[^a-zA-Z0-9]", "_"));
			e.printStackTrace();
		}
	      
    }
    public static void createHiveTable(Survey survey, List<String> disinctQuestions) {
    	Connection connection;
		try {
			connection = HiveConnection.getConnection();
		 Statement stmt = connection.createStatement();
	      // execute statement
		 	StringBuilder builder = new StringBuilder();
		 	
		 	builder.append("CREATE TABLE IF NOT EXISTS ");
		 	String tableName  = survey.getSurveyName().replaceAll("[^a-zA-Z0-9]", "_");
		 	builder.append(survey.getProjectGroupCode()+"."+tableName);
		 	builder.append("( client_id string, survey_date string , submission_id string ");
			  for(String question : disinctQuestions) {
				  try {
					String displayText = getQuestionDisplayTextByQuestionID("survey",UUID.fromString(question));
					if(StringUtils.isNotBlank(displayText)) {
						String columnName = displayText;
						if(displayText.length() > 100) {
							columnName = displayText.substring(0,100);
						}
						columnName = columnName.replaceAll("[^a-zA-Z0-9]", "_");
						columnName = columnName.replaceAll(" ", "_");
						builder.append(" ,q_"+columnName+" string ");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		  }
			  String query = builder.toString();
			  query = query +")";
			//  stmt.execute("DROP Table  IF EXISTS "+survey.getProjectGroupCode()+"."+tableName);
			//  System.out.println(" Create Query::"+ query);
	      stmt.execute(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
    }
    public static Survey getSurveyById(String schemaName,String surveyId) throws Exception{
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        Connection connection = null;
        try{
            connection = getConnection();
            statement = connection.prepareStatement(ViewQuery.GET_SURVEY_BY_ID);
            statement.setObject(1, UUID.fromString(surveyId));
            resultSet = statement.executeQuery();
            String projectGroupCode = null;
            String surveyName =  null;
            Date createdDate =  null;
            while(resultSet.next()) {
                 projectGroupCode = resultSet.getString("project_group_code");
                 surveyName = resultSet.getString("survey_title");
                 createdDate = resultSet.getDate("created_at");
            }
            Survey survey = new Survey(projectGroupCode,UUID.fromString(surveyId) , surveyName, createdDate);
            return survey;
        }catch (Exception ex){
            throw ex;
        }
    }
    public static String getQuestionDisplayTextByQuestionID(String schemaName,UUID questionId) throws Exception{
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        Connection connection = null;
        try{
            connection = getConnection();
            statement = connection.prepareStatement(ViewQuery.GET_DISPLAY_TEXT_FROM_QUESTION);
            statement.setObject(1, questionId);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
               return (String)resultSet.getString("display_text");
            }

        }catch (Exception ex){
            throw ex;
        }
        return null;
    }
    public static List<String> getDisinctSurveys(String schemaName) throws Exception{
        List<String> tables = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        Connection connection = null;
        try{
            connection = getConnection();
            statement = connection.prepareStatement(ViewQuery.GET_DISTINCT_SURVEY);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                tables.add(resultSet.getString("survey_id"));
            }

        }catch (Exception ex){
            throw ex;
        }
        return tables;
    }
    
    public static List<Response> getResponseBySubmissionClient(String schemaName,UUID surveyId, UUID clientId) throws Exception{
        List<Response> responses = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        Connection connection = null;
        try{
            connection = getConnection();
            statement = connection.prepareStatement(ViewQuery.GET_CLIENTS_WITH_RESPONSE);
            statement.setObject(1, surveyId);
            statement.setObject(2, clientId);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
            	String submissionId = resultSet.getString("submission_id");
            	String client  = resultSet.getString("client_id");
            	String questionId =  resultSet.getString("question_id");
            	String responseText = resultSet.getString("response_text");
            	Response response = new Response(submissionId, questionId, client,responseText);
            	responses.add(response);
            }
        }catch (Exception ex){
            throw ex;
        }
        return responses;
    }
    
    public static List<String> getDisinctQuestions(String schemaName,UUID surveyId) throws Exception{
        List<String> questions = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        Connection connection = null;
        try{
            connection = getConnection();
            statement = connection.prepareStatement(ViewQuery.GET_DISTINCT_QUESTIONS_FOR_SURVEY);
            statement.setObject(1, surveyId);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
            	questions.add(resultSet.getString("question_id"));
            }

        }catch (Exception ex){
            throw ex;
        }
        return questions;
    }
    
    public static void main(String args[]) throws Exception {
    	Properties props = new Properties();
		props.generatePropValues();
        while(true){
            createHiveTableForSurvey("MO0010");
            Long seconds = Long.valueOf(60) * 60;
            System.out.println("Sleep for 60 minutes");
            Thread.sleep(1000 * seconds);
        }
    }

}
