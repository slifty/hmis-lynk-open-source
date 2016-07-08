/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.HousingAssessmentDisposition;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.HousingAssessmentDisposition;
import com.servinglynk.hmis.warehouse.enums.HousingassessmentdispositionAssessmentdispositionEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Exit;
import com.servinglynk.hmis.warehouse.model.v2014.Housingassessmentdisposition;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class HousingassessmentdispositionDaoImpl extends ParentDaoImpl
		implements HousingassessmentdispositionDao {
	private static final Logger logger = LoggerFactory
			.getLogger(HousingassessmentdispositionDaoImpl.class);
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) throws Exception {
		List<HousingAssessmentDisposition> housingAssessmentDispositions = domain.getExport().getHousingAssessmentDisposition();
		Long i=new Long(0L);
		Data data =new Data();
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain));
		if(housingAssessmentDispositions !=null && !housingAssessmentDispositions.isEmpty()) 
		{
			for(HousingAssessmentDisposition housingAssessmentDisposition : housingAssessmentDispositions)
			{
				try {
					Housingassessmentdisposition housingassessmentdispositionModel = getModelObject(domain, housingAssessmentDisposition,data);
					housingassessmentdispositionModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(housingAssessmentDisposition.getDateCreated()));
					housingassessmentdispositionModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(housingAssessmentDisposition.getDateUpdated()));
					housingassessmentdispositionModel.setAssessmentdisposition(HousingassessmentdispositionAssessmentdispositionEnum.lookupEnum(BasicDataGenerator.getStringValue(housingAssessmentDisposition.getAssessmentDisposition())));
					housingassessmentdispositionModel.setOtherdisposition(housingAssessmentDisposition.getOtherDisposition());
					Exit exit = (Exit) getModel(Exit.class,housingAssessmentDisposition.getExitID(),getProjectGroupCode(domain));
					housingassessmentdispositionModel.setExitid(exit);
					housingassessmentdispositionModel.setExport(exportEntity);
					if(exportEntity != null)
						exportEntity.addHousingassessmentdisposition(housingassessmentdispositionModel);
					performSaveOrUpdate(housingassessmentdispositionModel);
				}catch(Exception e) {
					logger.error("Exception in:"+housingAssessmentDisposition.getHousingAssessmentDispositionID()+  ":: Exception" +e.getLocalizedMessage());
					throw new Exception(e);
				}
			
			}
		}
	}
	
	public com.servinglynk.hmis.warehouse.model.v2014.Housingassessmentdisposition getModelObject(ExportDomain domain,HousingAssessmentDisposition HousingAssessmentDisposition ,Data data) {
		com.servinglynk.hmis.warehouse.model.v2014.Housingassessmentdisposition housingAssessmentDispositionModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			housingAssessmentDispositionModel = (com.servinglynk.hmis.warehouse.model.v2014.Housingassessmentdisposition) getModel(com.servinglynk.hmis.warehouse.model.v2014.Housingassessmentdisposition.class, HousingAssessmentDisposition.getHousingAssessmentDispositionID(), getProjectGroupCode(domain));
		
		if(housingAssessmentDispositionModel == null) {
			housingAssessmentDispositionModel = new com.servinglynk.hmis.warehouse.model.v2014.Housingassessmentdisposition();
			housingAssessmentDispositionModel.setId(UUID.randomUUID());
			housingAssessmentDispositionModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(housingAssessmentDispositionModel, domain,HousingAssessmentDisposition.getHousingAssessmentDispositionID(),data.i+data.j);
		return housingAssessmentDispositionModel;
	}
	   public com.servinglynk.hmis.warehouse.model.v2014.Housingassessmentdisposition createHousingAssessmentDisposition(com.servinglynk.hmis.warehouse.model.v2014.Housingassessmentdisposition housingAssessmentDisposition){
	       housingAssessmentDisposition.setId(UUID.randomUUID()); 
	       insert(housingAssessmentDisposition);
	       return housingAssessmentDisposition;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Housingassessmentdisposition updateHousingAssessmentDisposition(com.servinglynk.hmis.warehouse.model.v2014.Housingassessmentdisposition housingAssessmentDisposition){
	       update(housingAssessmentDisposition);
	       return housingAssessmentDisposition;
	   }
	   public void deleteHousingAssessmentDisposition(com.servinglynk.hmis.warehouse.model.v2014.Housingassessmentdisposition housingAssessmentDisposition){
	       delete(housingAssessmentDisposition);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Housingassessmentdisposition getHousingAssessmentDispositionById(UUID housingAssessmentDispositionId){ 
	       return (com.servinglynk.hmis.warehouse.model.v2014.Housingassessmentdisposition) get(com.servinglynk.hmis.warehouse.model.v2014.Housingassessmentdisposition.class, housingAssessmentDispositionId);
	   }
	   
	   @SuppressWarnings("unchecked")
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Housingassessmentdisposition> getAllExitHousingAssessmentDispositions(UUID exitId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Housingassessmentdisposition.class);
	       criteria.createAlias("exitid", "exitid");
	       criteria.add(Restrictions.eq("exitid.id", exitId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Housingassessmentdisposition>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getExitHousingAssessmentDispositionsCount(UUID exitId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Housingassessmentdisposition.class);
	       criteria.createAlias("exitid", "exitid");
	       criteria.add(Restrictions.eq("exitid.id", exitId));
	       return countRows(criteria);
	   }
}
