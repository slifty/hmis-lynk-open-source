package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.Education;
import com.servinglynk.hmis.warehouse.enums.LastgradecompletedLastgradecompletedEnum;
import com.servinglynk.hmis.warehouse.enums.SchoolStatusEnum;
public class EducationConverter  extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2015.Education modelToEntity (Education model ,com.servinglynk.hmis.warehouse.model.v2015.Education entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2015.Education();
       entity.setId(model.getEducationId());
       if(model.getLastgradecompleted()!=null)
       entity.setLastgradecompleted(LastgradecompletedLastgradecompletedEnum.lookupEnum(model.getLastgradecompleted().toString()));
       if(model.getSchoolStatus()!=null)
       entity.setSchoolStatus(SchoolStatusEnum.lookupEnum(model.getSchoolStatus().toString()));
       return entity;    
   }


   public static Education entityToModel (com.servinglynk.hmis.warehouse.model.v2015.Education entity) {
       Education model = new Education();
       model.setEducationId(entity.getId());
       if(entity.getLastgradecompleted()!=null)
       model.setLastgradecompleted(Integer.parseInt(entity.getLastgradecompleted().getValue()));
       if(entity.getSchoolStatus()!=null)
       model.setSchoolStatus(Integer.parseInt(entity.getSchoolStatus().getValue()));
       return model;
   }


}