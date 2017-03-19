/**
 *
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

/**
 * @author Sandeep
 *
 */
public interface IncomeandsourcesDao extends ParentDao {



	   com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources createIncomeAndSource(com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources incomeAndSource);
	   com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources updateIncomeAndSource(com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources incomeAndSource);
	   void deleteIncomeAndSource(com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources incomeAndSource);
	   com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources getIncomeAndSourceById(UUID incomeAndSourceId);
	   List<com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources> getAllEnrollmentIncomeAndSources(UUID enrollmentId,Integer startIndex, Integer maxItems);
	   long getEnrollmentIncomeAndSourcesCount(UUID enrollmentId);
}
