/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ReferralSource;
import com.servinglynk.hmis.warehouse.enums.ReferralsourceReferralsourceEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.Referralsource;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class ReferralsourceDaoImpl extends ParentDaoImpl implements
		ReferralsourceDao {
	private static final Logger logger = LoggerFactory
			.getLogger(ReferralsourceDaoImpl.class);

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) throws Exception {
		List<ReferralSource> referralSources = domain.getExport().getReferralSource();
		Long i=new Long(0L);
		Data data =new Data();
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain));
		if(referralSources !=null && !referralSources.isEmpty())
		{
			for(ReferralSource referralSource : referralSources) {
				try {
					Referralsource referralsourceModel = getModelObject(domain, referralSource,data);
					referralsourceModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(referralSource.getDateCreated()));
					referralsourceModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(referralSource.getDateUpdated()));
					referralsourceModel.setReferralsource(ReferralsourceReferralsourceEnum.lookupEnum(BasicDataGenerator.getStringValue(referralSource.getReferralSource())));
					referralsourceModel.setCountoutreachreferralapproaches(BasicDataGenerator.getIntegerValue(referralSource.getCountOutreachReferralApproaches()));
					Enrollment enrollmentModel = (Enrollment) getModel(Enrollment.class,referralSource.getProjectEntryID(),getProjectGroupCode(domain));
					referralsourceModel.setEnrollmentid(enrollmentModel);
					referralsourceModel.setExport(exportEntity);
					if(exportEntity !=null)
						exportEntity.addReferralsource(referralsourceModel);
					performSaveOrUpdate(referralsourceModel);
				}catch(Exception e) {
					logger.error("Failure in ReferralSource:::"+referralSource.toString()+ " with exception"+e.getLocalizedMessage());
					 throw new Exception(e);
				}
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j, Referralsource.class.getSimpleName(), domain, exportEntity);
	}
	public com.servinglynk.hmis.warehouse.model.v2014.Referralsource getModelObject(ExportDomain domain,ReferralSource referralsource ,Data data) {
		com.servinglynk.hmis.warehouse.model.v2014.Referralsource referralsourceModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			referralsourceModel = (com.servinglynk.hmis.warehouse.model.v2014.Referralsource) getModel(com.servinglynk.hmis.warehouse.model.v2014.Referralsource.class, referralsource.getReferralSourceID(), getProjectGroupCode(domain));
		
		if(referralsourceModel == null) {
			referralsourceModel = new com.servinglynk.hmis.warehouse.model.v2014.Referralsource();
			referralsourceModel.setId(UUID.randomUUID());
			referralsourceModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(referralsourceModel, domain,referralsource.getReferralSourceID(),data.i+data.j);
		return referralsourceModel;
	}
	public com.servinglynk.hmis.warehouse.model.v2014.Referralsource createReferralsource(com.servinglynk.hmis.warehouse.model.v2014.Referralsource referralsource){
	       referralsource.setId(UUID.randomUUID()); 
	       insert(referralsource);
	       return referralsource;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Referralsource updateReferralsource(com.servinglynk.hmis.warehouse.model.v2014.Referralsource referralsource){
	       update(referralsource);
	       return referralsource;
	   }
	   public void deleteReferralsource(com.servinglynk.hmis.warehouse.model.v2014.Referralsource referralsource){
	       delete(referralsource);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Referralsource getReferralsourceById(UUID referralsourceId){ 
	       return (com.servinglynk.hmis.warehouse.model.v2014.Referralsource) get(com.servinglynk.hmis.warehouse.model.v2014.Referralsource.class, referralsourceId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Referralsource> getAllEnrollmentReferralsources(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Referralsource.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Referralsource>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentReferralsourcesCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Referralsource.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }

}
