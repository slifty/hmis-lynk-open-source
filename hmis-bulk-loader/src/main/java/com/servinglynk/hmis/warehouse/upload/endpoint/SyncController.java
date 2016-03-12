package com.servinglynk.hmis.warehouse.upload.endpoint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.servinglynk.hmis.warehouse.model.v2014.Sync;
import com.servinglynk.hmis.warehouse.upload.business.service.core.ParentServiceFactory;

@RestController
@RequestMapping("/sync")
public class SyncController {
	private static final Logger logger = LoggerFactory
			.getLogger(SyncController.class);
	 @Autowired
    protected ParentServiceFactory parentServiceFactory;
	 
	 @RequestMapping(method = RequestMethod.GET)
		public @ResponseBody
	 List<SyncDTO> listOfSyncs() {
		 ResultSet resultSet = null;
		 List<SyncDTO> syncList = new ArrayList<SyncDTO>();
			Connection connection = null;
			try {
				connection = getConnection();

				String queryString = "SELECT * FROM live.sync order by date_created desc" ;
				PreparedStatement statement = connection.prepareStatement(queryString);
				resultSet = statement.executeQuery();
				
				 while (resultSet.next()) {
					 SyncDTO sync = new SyncDTO();
					 sync.setDateCreated(resultSet.getTimestamp("date_created"));
					 //sync.setresultSet.getTimestamp("date_updated");
					 sync.setJson(resultSet.getString("json"));
					 sync.setStatus(resultSet.getString("status"));
					 syncList.add(sync);
				 }
					
				}catch(Exception ex){
					
				}
		 
		return syncList;
	}
		private Connection getConnection() throws SQLException {
			Connection connection = DriverManager.getConnection(
					"jdbc:postgresql://hmisdb1.cvvhlvb3ryja.us-west-2.rds.amazonaws.com:5432/hmis", "hmisdb1",
					"hmisdb1234");
			return connection;
		}
}
