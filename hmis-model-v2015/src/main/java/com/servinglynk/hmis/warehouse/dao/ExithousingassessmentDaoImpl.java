/**
 *
 */
package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.springframework.beans.BeanUtils;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ExitHousingAssessment;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.ExithousingassessmentHousingassessmentEnum;
import com.servinglynk.hmis.warehouse.enums.ExithousingassessmentSubsidyinformationEnum;
import com.servinglynk.hmis.warehouse.model.stagv2015.Exit;
import com.servinglynk.hmis.warehouse.model.stagv2015.Exithousingassessment;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class ExithousingassessmentDaoImpl extends ParentDaoImpl implements
		ExithousingassessmentDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		List<ExitHousingAssessment> exitHousingAssessments = domain.getExport().getExitHousingAssessment();
		if(exitHousingAssessments !=null && !exitHousingAssessments.isEmpty())
		{
				for(ExitHousingAssessment exitHousingAssessment : exitHousingAssessments)
				{
					Exithousingassessment exithousingassessmentModel = new Exithousingassessment();
					exithousingassessmentModel.setId(UUID.randomUUID());
					exithousingassessmentModel.setDateCreated(LocalDateTime.now());
					exithousingassessmentModel.setDateUpdated(LocalDateTime.now());
					exithousingassessmentModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(exitHousingAssessment.getDateCreated()));
					exithousingassessmentModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(exitHousingAssessment.getDateUpdated()));
					exithousingassessmentModel.setHousingassessment(ExithousingassessmentHousingassessmentEnum.lookupEnum(BasicDataGenerator.getStringValue(exitHousingAssessment.getHousingAssessment())));
					exithousingassessmentModel.setSubsidyinformation(ExithousingassessmentSubsidyinformationEnum.lookupEnum(BasicDataGenerator.getStringValue(exitHousingAssessment.getSubsidyInformation())));
					Exit exit = (Exit) get(Exit.class, domain.getExitMap().get(exitHousingAssessment.getExitID()));
					exithousingassessmentModel.setExitid(exit);
					com.servinglynk.hmis.warehouse.model.stagv2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.stagv2015.Export) get(com.servinglynk.hmis.warehouse.model.stagv2015.Export.class, domain.getExportId());
					exithousingassessmentModel.setExport(exportEntity);
					exportEntity.addExithousingassessment(exithousingassessmentModel);
					hydrateCommonFields(exithousingassessmentModel, domain);
					insertOrUpdate(exithousingassessmentModel);
				}
		}
	}

	@Override
	public void hydrateLive(
			com.servinglynk.hmis.warehouse.model.stagv2015.Export export) {
		Set<Exithousingassessment> exithousingassessments = export.getExithousingassessments();
		if(exithousingassessments !=null && !exithousingassessments.isEmpty()) {
			for(Exithousingassessment exithousingassessment : exithousingassessments) {
				if(exithousingassessment !=null) {
					com.servinglynk.hmis.warehouse.model.v2015.Exithousingassessment target = new com.servinglynk.hmis.warehouse.model.v2015.Exithousingassessment();
					BeanUtils.copyProperties(exithousingassessment, target,getNonCollectionFields(target));
					com.servinglynk.hmis.warehouse.model.v2015.Exit exitModel = (com.servinglynk.hmis.warehouse.model.v2015.Exit) get(com.servinglynk.hmis.warehouse.model.v2015.Exit.class, exithousingassessment.getExitid().getId());
					target.setExitid(exitModel);
					com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) get(com.servinglynk.hmis.warehouse.model.v2015.Export.class, export.getId());
					target.setExport(exportEntity);
					exportEntity.addExithousingassessment(target);
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

}