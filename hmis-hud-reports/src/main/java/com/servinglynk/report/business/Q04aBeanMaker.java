package com.servinglynk.report.business;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.hive.connection.HiveConnection;
import com.servinglynk.hive.connection.ReportQuery;
import com.servinglynk.report.bean.Q04aDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.ProjectModel;

public class Q04aBeanMaker {
	
			public static List<Q04aDataBean> getQ04aDataBeanList(String schema, String projectId,ReportData data) {
				Q04aDataBean q04aDataBean = new Q04aDataBean(); 
				populateProject(schema, projectId, q04aDataBean,data);
				return Arrays.asList(q04aDataBean);
			}
			public static void populateProject(String schema,String id, Q04aDataBean q04aDataBean,ReportData data ) {
				ResultSet resultSet = null;
				PreparedStatement statement = null;
				Connection connection = null;
				try {
					connection = HiveConnection.getConnection();
					statement = connection.prepareStatement(String.format(ReportQuery.GET_PROJECT_BY_ID,schema));
					statement.setString(1, id);
					resultSet = statement.executeQuery();
					while(resultSet.next()) {
					 q04aDataBean.setQ04aProjectName(resultSet.getString("project.projectname"));
					 q04aDataBean.setQ04aHmisProjectType(resultSet.getString("project.projecttype_desc"));
					 q04aDataBean.setQ04aProjectId(resultSet.getString("project.source_system_id"));
					 q04aDataBean.setQ04aMethodOfTracking(resultSet.getString("project.trackingmethod_desc"));
					 String organizationId = resultSet.getString("project.organizationid");
					 ProjectModel project = new ProjectModel(q04aDataBean.getQ04aProjectName(), q04aDataBean.getQ04aHmisProjectType(), id, q04aDataBean.getQ04aOrgId());
					 data.setProject(project);
					populateOranization(schema, organizationId, q04aDataBean);
				 }
					
					q04aDataBean.setQ04aProjectName("project.projectname");
					 q04aDataBean.setQ04aHmisProjectType("project.projecttype_desc");
					 q04aDataBean.setQ04aProjectId("project.source_system_id");
					 q04aDataBean.setQ04aMethodOfTracking("project.trackingmethod_desc");
					 q04aDataBean.setQ04aIdentityProjectId(BigInteger.ZERO);
					 q04aDataBean.setQ04aHmisProjectIdService(BigInteger.ZERO);
					 String organizationId = resultSet.getString("project.organizationid");
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					if (statement != null) {
						try {
							statement.close();
							//connection.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
				public static void populateOranization(String schema,String id, Q04aDataBean q04aDataBean) {
					ResultSet resultSet = null;
					PreparedStatement statement = null;
					Connection connection = null;
					try {
						connection = HiveConnection.getConnection();
						statement = connection.prepareStatement(String.format(ReportQuery.GET_ORG_BY_ID,schema));
						statement.setString(1, id);
						resultSet = statement.executeQuery();
//						int count = 0;
					 while(resultSet.next()) {
						 q04aDataBean.setQ04aOrgName(resultSet.getString("organization.organizationname"));
						 q04aDataBean.setQ04aOrgId(resultSet.getString("organization.source_system_id"));
					 }
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						if (statement != null) {
							try {
								statement.close();
								//connection.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
}
