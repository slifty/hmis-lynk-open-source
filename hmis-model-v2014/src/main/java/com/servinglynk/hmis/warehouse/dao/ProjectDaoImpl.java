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
import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Project;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.ProjectContinuumprojectEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectProjecttypeEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectResidentialaffiliationEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectTargetpopulationEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectTrackingmethodEnum;
import com.servinglynk.hmis.warehouse.model.stagv2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.stagv2014.Export;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class ProjectDaoImpl extends ParentDaoImpl implements ProjectDao {

	@Autowired
	private ParentDaoFactory factory;
	
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		
		List<Project> projects = domain.getExport().getProject();
		if(projects !=null && projects.size() > 0)
		{
			
			for(Project project : projects)
			{
				com.servinglynk.hmis.warehouse.model.stagv2014.Project projectModel = new com.servinglynk.hmis.warehouse.model.stagv2014.Project();
				UUID id = UUID.randomUUID();
				projectModel.setId(id);
				//projectModel.setAffiliations(affiliation);
				projectModel.setContinuumproject(ProjectContinuumprojectEnum.lookupEnum(BasicDataGenerator.getStringValue(project.getContinuumProject())));
				//projectModel.setFunders(funder);
				domain.getOrganizationProjectMap().put(BasicDataGenerator.getStringValue(project.getOrganizationID()),id);
				domain.getAffiliationProjectMap().put(project.getProjectID(), id);
				domain.getProjectCocMap().put(project.getProjectID(), id);
				//projectModel.setProjectcocs(projectcoc);
				projectModel.setProjectname(project.getProjectName());
				projectModel.setProjectcommonname(project.getProjectCommonName());
				projectModel.setProjecttype(ProjectProjecttypeEnum.lookupEnum(BasicDataGenerator.getStringValue(project.getProjectType())));
				projectModel.setResidentialaffiliation(ProjectResidentialaffiliationEnum.lookupEnum(BasicDataGenerator.getStringValue(project.getResidentialAffiliation())));
				projectModel.setTargetpopulation(ProjectTargetpopulationEnum.lookupEnum(BasicDataGenerator.getStringValue(project.getTargetPopulation())));
				projectModel.setTrackingmethod(ProjectTrackingmethodEnum.lookupEnum(BasicDataGenerator.getStringValue(project.getTrackingMethod())));
				projectModel.setDateCreated(LocalDateTime.now());
				projectModel.setDateUpdated(LocalDateTime.now());
				projectModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(project.getDateCreated()));
				projectModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(project.getDateUpdated()));
				if(project.getProjectID() !=null && !"".equals(project.getProjectID())) {
					UUID uuid = domain.getEnrollmentProjectEntryIDMap().get(project.getProjectID());
					if(uuid !=null) {
						Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, uuid);
						projectModel.setEnrollmentid(enrollmentModel);
					}
				}
				com.servinglynk.hmis.warehouse.model.stagv2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.stagv2014.Export) get(com.servinglynk.hmis.warehouse.model.stagv2014.Export.class, domain.getExportId());
				projectModel.setExport(exportEntity);
				exportEntity.addProject(projectModel);
				hydrateCommonFields(projectModel, domain);
				insertOrUpdate(projectModel);
			}
			factory.getOrganizationDao().hydrateStaging(domain);
			factory.getAffiliationDao().hydrateStaging(domain);
			factory.getFunderDao().hydrateStaging(domain);
			}

	}

	@Override
	public void hydrateLive(Export export) {
		Set<com.servinglynk.hmis.warehouse.model.stagv2014.Project> projects = export.getProjects();
		if(projects != null && !projects.isEmpty()) {
			for(com.servinglynk.hmis.warehouse.model.stagv2014.Project project : projects) {
				if(project != null) {
					com.servinglynk.hmis.warehouse.model.v2014.Project target = new com.servinglynk.hmis.warehouse.model.v2014.Project();
					BeanUtils.copyProperties(project, target,getNonCollectionFields(target));
					com.servinglynk.hmis.warehouse.model.v2014.Enrollment enrollmentModel = (com.servinglynk.hmis.warehouse.model.v2014.Enrollment) get(com.servinglynk.hmis.warehouse.model.v2014.Enrollment.class, project.getEnrollmentid().getId());
					target.setEnrollmentid(enrollmentModel);
					com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class, export.getId());
					target.setExport(exportEntity);
					com.servinglynk.hmis.warehouse.model.v2014.Organization orgEntity = (com.servinglynk.hmis.warehouse.model.v2014.Organization) get(com.servinglynk.hmis.warehouse.model.v2014.Organization.class, project.getOrganizationid().getId());
					target.setOrganizationid(orgEntity);
					target.setDateCreated(LocalDateTime.now());
					 target.setDateUpdated(LocalDateTime.now());
					insert(target);
				}
			}
			factory.getAffiliationDao().hydrateLive(export);
			factory.getFunderDao().hydrateLive(export);
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
	   public com.servinglynk.hmis.warehouse.model.v2014.Project createProject(com.servinglynk.hmis.warehouse.model.v2014.Project project){
		   project.setId(UUID.randomUUID());
	       insert(project);
	       return project;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Project updateProject(com.servinglynk.hmis.warehouse.model.v2014.Project project){
	       update(project);
	       return project;
	   }
	   public void deleteProject(com.servinglynk.hmis.warehouse.model.v2014.Project project){
	       delete(project);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Project getProjectById(UUID projectId){ 
	       return (com.servinglynk.hmis.warehouse.model.v2014.Project) get(com.servinglynk.hmis.warehouse.model.v2014.Project.class, projectId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Project> getAllProjects(UUID organizationId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Project.class);
	       criteria.createAlias("organizationid", "organizationid");
	       criteria.add(Restrictions.eq("organizationid.id", organizationId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Project>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getProjectCount(UUID organizationId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Project.class);
	       criteria.createAlias("organizationid", "organizationid");
	       criteria.add(Restrictions.eq("organizationid.id", organizationId));
	       return countRows(criteria);
	   }
}