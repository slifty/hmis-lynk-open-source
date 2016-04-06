/**
 *
 */
package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.NonCashBenefits;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsBenefitsfromanysourceEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsOthersourceEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsOthertanfEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsRentalassistanceongoingEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsRentalassistancetempEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsSnapEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsTanfchildcareEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsTanftransportationEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsWicEnum;
import com.servinglynk.hmis.warehouse.model.stagv2015.Enrollment;
import com.servinglynk.hmis.warehouse.model.stagv2015.Export;
import com.servinglynk.hmis.warehouse.model.stagv2015.Noncashbenefits;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class NoncashbenefitsDaoImpl extends ParentDaoImpl implements
		NoncashbenefitsDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		List<NonCashBenefits> nonCashBenefitsList = domain.getExport().getNonCashBenefits();
		hydrateBulkUploadActivityStaging(nonCashBenefitsList, com.servinglynk.hmis.warehouse.model.v2015.Noncashbenefits.class.getSimpleName(), domain);
		if(nonCashBenefitsList !=null && !nonCashBenefitsList.isEmpty())
		{
			for(NonCashBenefits nonCashBenefits : nonCashBenefitsList)
			{
				Noncashbenefits noncashbenefitsModel = new Noncashbenefits();
				UUID id = UUID.randomUUID();
				noncashbenefitsModel.setId(id);
				noncashbenefitsModel.setDateCreated(LocalDateTime.now());
				noncashbenefitsModel.setDateUpdated(LocalDateTime.now());
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
				if(nonCashBenefits.getProjectEntryID() !=null && !"".equals(nonCashBenefits.getProjectEntryID())) {
					UUID uuid = domain.getEnrollmentProjectEntryIDMap().get(nonCashBenefits.getProjectEntryID());
					if(uuid !=null) {
						Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, uuid);
						noncashbenefitsModel.setEnrollmentid(enrollmentModel);
					}
				}
				com.servinglynk.hmis.warehouse.model.stagv2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.stagv2015.Export) get(com.servinglynk.hmis.warehouse.model.stagv2015.Export.class, domain.getExportId());
				noncashbenefitsModel.setExport(exportEntity);
				exportEntity.addNoncashbenefits(noncashbenefitsModel);
				hydrateCommonFields(noncashbenefitsModel, domain);
				insertOrUpdate(noncashbenefitsModel);
			}
		}

	}

	@Override
	public void hydrateLive(Export export, Long id) {
		Set<Noncashbenefits> noncashbenefitss = export.getNoncashbenefitss();
		hydrateBulkUploadActivity(noncashbenefitss, com.servinglynk.hmis.warehouse.model.v2015.Noncashbenefits.class.getSimpleName(), export,id);
		if(noncashbenefitss != null && !noncashbenefitss.isEmpty()) {
			for(Noncashbenefits noncashbenefits : noncashbenefitss) {
				if(noncashbenefits != null) {
					com.servinglynk.hmis.warehouse.model.v2015.Noncashbenefits target = new com.servinglynk.hmis.warehouse.model.v2015.Noncashbenefits();
					BeanUtils.copyProperties(noncashbenefits, target,getNonCollectionFields(target));
					if(noncashbenefits.getEnrollmentid() !=null && noncashbenefits.getEnrollmentid().getId() !=null) {
						com.servinglynk.hmis.warehouse.model.v2015.Enrollment enrollmentModel = (com.servinglynk.hmis.warehouse.model.v2015.Enrollment) get(com.servinglynk.hmis.warehouse.model.v2015.Enrollment.class, noncashbenefits.getEnrollmentid().getId());
						target.setEnrollmentid(enrollmentModel);
					}
					com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) get(com.servinglynk.hmis.warehouse.model.v2015.Export.class, export.getId());
					target.setExport(exportEntity);
					exportEntity.addNoncashbenefits(target);
					target.setDateCreated(LocalDateTime.now());
					target.setDateUpdated(LocalDateTime.now());
					insertOrUpdate(target);
				}
			}
		}
	}

	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void performSave(Iface client, Object entity) {
		// TODO Auto-generated method stub

	}

	@Override
	protected List performGet(Iface client, Object entity) {
		// TODO Auto-generated method stub
		return null;
	}


	   public com.servinglynk.hmis.warehouse.model.v2015.Noncashbenefits createNoncashbenefits(com.servinglynk.hmis.warehouse.model.v2015.Noncashbenefits noncashbenefits){
	       noncashbenefits.setId(UUID.randomUUID());
	       insert(noncashbenefits);
	       return noncashbenefits;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2015.Noncashbenefits updateNoncashbenefits(com.servinglynk.hmis.warehouse.model.v2015.Noncashbenefits noncashbenefits){
	       update(noncashbenefits);
	       return noncashbenefits;
	   }
	   public void deleteNoncashbenefits(com.servinglynk.hmis.warehouse.model.v2015.Noncashbenefits noncashbenefits){
	       delete(noncashbenefits);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2015.Noncashbenefits getNoncashbenefitsById(UUID noncashbenefitsId){
	       return (com.servinglynk.hmis.warehouse.model.v2015.Noncashbenefits) get(com.servinglynk.hmis.warehouse.model.v2015.Noncashbenefits.class, noncashbenefitsId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2015.Noncashbenefits> getAllEnrollmentNoncashbenefits(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Noncashbenefits.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2015.Noncashbenefits>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentNoncashbenefitsCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Noncashbenefits.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }
}
