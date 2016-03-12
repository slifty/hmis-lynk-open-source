package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.Sexualorientation;
import com.servinglynk.hmis.warehouse.enums.SexualorientationSexualorientationEnum;
public class SexualorientationConverter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation modelToEntity (Sexualorientation model ,com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation();
       entity.setId(model.getSexualorientationId());
       entity.setSexualorientation(SexualorientationSexualorientationEnum.valueOf(model.getSexualorientation()));
       return entity;    
   }


   public static Sexualorientation entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation entity) {
       Sexualorientation model = new Sexualorientation();
       model.setSexualorientationId(entity.getId());
       model.setSexualorientation(entity.getSexualorientation().name());
       return model;
   }


}
