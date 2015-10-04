package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.Project;
import com.servinglynk.hmis.warehouse.enums.ProjectContinuumprojectEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectProjecttypeEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectResidentialaffiliationEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectTargetpopulationEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectTrackingmethodEnum;
public class ProjectConverter {

   public static com.servinglynk.hmis.warehouse.model.live.Project modelToEntity (Project model ,com.servinglynk.hmis.warehouse.model.live.Project entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.live.Project();
       
       entity.setProjectname(model.getProjectName());
       entity.setContinuumproject(ProjectContinuumprojectEnum.valueOf(model.getContinuumProject()));
       entity.setProjectcommonname(model.getProjectCommonName());
       entity.setProjecttype(ProjectProjecttypeEnum.valueOf(model.getProjectType()));
       entity.setResidentialaffiliation(ProjectResidentialaffiliationEnum.valueOf(model.getResidentialAffiliation()));
       entity.setTrackingmethod(ProjectTrackingmethodEnum.valueOf(model.getTrackingMethod()));
       entity.setTargetpopulation(ProjectTargetpopulationEnum.valueOf(model.getTargetPopulation()));
       return entity;    
   }


   public static Project entityToModel (com.servinglynk.hmis.warehouse.model.live.Project entity) {
       Project project= new Project();
       
       project.setContinuumProject(entity.getContinuumproject().name());
       project.setProjectCommonName(entity.getProjectcommonname());
       project.setProjectId(entity.getId());
       project.setProjectName(entity.getProjectname());
       project.setProjectType(entity.getProjecttype().name());
       project.setResidentialAffiliation(entity.getResidentialaffiliation().name());
       project.setTargetPopulation(entity.getTargetpopulation().name());
       project.setTrackingMethod(entity.getTrackingmethod().name());
       
       return project;
   }


}