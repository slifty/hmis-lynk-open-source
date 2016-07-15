/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.NonCashBenefits;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsBenefitsfromanysourceEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsOthersourceEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsOthertanfEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsRentalassistanceongoingEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsRentalassistancetempEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsSnapEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsTanfchildcareEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsTanftransportationEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsWicEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;
import com.servinglynk.hmis.warehouse.model.v2014.Noncashbenefits;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class NoncashbenefitsDaoImpl extends ParentDaoImpl implements
		NoncashbenefitsDao {
	private static final Logger logger = LoggerFactory
			.getLogger(NoncashbenefitsDaoImpl.class);
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		List<NonCashBenefits> nonCashBenefitsList = domain.getExport().getNonCashBenefits();
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Noncashbenefits.class, getProjectGroupCode(domain));
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap);
		if(nonCashBenefitsList !=null && !nonCashBenefitsList.isEmpty())
		{
			for(NonCashBenefits nonCashBenefits : nonCashBenefitsList)
			{
				try {
					Noncashbenefits noncashbenefitsModel = getModelObject(domain, nonCashBenefits,data,modelMap);
					noncashbenefitsModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(nonCashBenefits.getDateCreated()));
					noncashbenefitsModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(nonCashBenefits.getDateUpdated()));
					noncashbenefitsModel.setBenefitsfromanysource(NoncashbenefitsBenefitsfromanysourceEnum.lookupEnum(BasicDataGenerator.getStringValue(nonCashBenefits.getBenefitsFromAnySource())));
					noncashbenefitsModel.setOthersource(NoncashbenefitsOthersourceEnum.lookupEnum(BasicDataGenerator.getStringValue(nonCashBenefits.getOtherSource())));
					noncashbenefitsModel.setOthersourceidentify(nonCashBenefits.getOtherSourceIdentify());
					noncashbenefitsModel.setOthertanf(NoncashbenefitsOthertanfEnum.lookupEnum(BasicDataGenerator.getStringValue(nonCashBenefits.getOtherTANF())));
					noncashbenefitsModel.setRentalassistanceongoing(NoncashbenefitsRentalassistanceongoingEnum.lookupEnum(BasicDataGenerator.getStringValue(nonCashBenefits.getRentalAssistanceOngoing())));
					noncashbenefitsModel.setRentalassistancetemp(NoncashbenefitsRentalassistancetempEnum.lookupEnum(BasicDataGenerator.getStringValue(nonCashBenefits.getRentalAssistanceTemp())));
					noncashbenefitsModel.setSnap(NoncashbenefitsSnapEnum.lookupEnum(BasicDataGenerator.getStringValue(nonCashBenefits.getSNAP())));
					noncashbenefitsModel.setTanfchildcare(NoncashbenefitsTanfchildcareEnum.lookupEnum(BasicDataGenerator.getStringValue(nonCashBenefits.getTANFChildCare())));
					noncashbenefitsModel.setTanftransportation(NoncashbenefitsTanftransportationEnum.lookupEnum(BasicDataGenerator.getStringValue(nonCashBenefits.getTANFTransportation())));
					noncashbenefitsModel.setWic(NoncashbenefitsWicEnum.lookupEnum(BasicDataGenerator.getStringValue(nonCashBenefits.getWIC())));
					Enrollment enrollmentModel = (Enrollment) getModel(Enrollment.class, nonCashBenefits.getProjectEntryID(),getProjectGroupCode(domain),true,relatedModelMap);
					noncashbenefitsModel.setEnrollmentid(enrollmentModel);
					noncashbenefitsModel.setExport(exportEntity);
					if (exportEntity !=null)
						exportEntity.addNoncashbenefits(noncashbenefitsModel);
					performSaveOrUpdate(noncashbenefitsModel);
				}catch(Exception e) {
					logger.error("Failure in Noncashbenefits:::"+nonCashBenefits.toString()+ " with exception"+e.getLocalizedMessage());
					throw new Exception(e);
				}
			}
		}
	}
	
	public com.servinglynk.hmis.warehouse.model.v2014.Noncashbenefits getModelObject(ExportDomain domain,NonCashBenefits noncashbenefits ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2014.Noncashbenefits NoncashbenefitsModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			NoncashbenefitsModel = (com.servinglynk.hmis.warehouse.model.v2014.Noncashbenefits) getModel(com.servinglynk.hmis.warehouse.model.v2014.Noncashbenefits.class, noncashbenefits.getNonCashBenefitsID(), getProjectGroupCode(domain),false,modelMap);
		
		if(NoncashbenefitsModel == null) {
			NoncashbenefitsModel = new com.servinglynk.hmis.warehouse.model.v2014.Noncashbenefits();
			NoncashbenefitsModel.setId(UUID.randomUUID());
			NoncashbenefitsModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(NoncashbenefitsModel, domain,noncashbenefits.getNonCashBenefitsID(),data.i+data.j);
		return NoncashbenefitsModel;
	}

	   public com.servinglynk.hmis.warehouse.model.v2014.Noncashbenefits createNoncashbenefits(com.servinglynk.hmis.warehouse.model.v2014.Noncashbenefits noncashbenefits){
	       noncashbenefits.setId(UUID.randomUUID()); 
	       insert(noncashbenefits);
	       return noncashbenefits;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Noncashbenefits updateNoncashbenefits(com.servinglynk.hmis.warehouse.model.v2014.Noncashbenefits noncashbenefits){
	       update(noncashbenefits);
	       return noncashbenefits;
	   }
	   public void deleteNoncashbenefits(com.servinglynk.hmis.warehouse.model.v2014.Noncashbenefits noncashbenefits){
	       delete(noncashbenefits);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Noncashbenefits getNoncashbenefitsById(UUID noncashbenefitsId){ 
	       return (com.servinglynk.hmis.warehouse.model.v2014.Noncashbenefits) get(com.servinglynk.hmis.warehouse.model.v2014.Noncashbenefits.class, noncashbenefitsId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Noncashbenefits> getAllEnrollmentNoncashbenefits(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Noncashbenefits.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Noncashbenefits>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentNoncashbenefitsCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Noncashbenefits.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }
}
