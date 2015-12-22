package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.Projectcoc;
public class ProjectcocConverter {

   public static com.servinglynk.hmis.warehouse.model.live.Projectcoc modelToEntity (Projectcoc model ,com.servinglynk.hmis.warehouse.model.live.Projectcoc entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.live.Projectcoc();
       entity.setCoccode(model.getCoccode());
       return entity;    
   }


   public static Projectcoc entityToModel (com.servinglynk.hmis.warehouse.model.live.Projectcoc entity) {
       Projectcoc model = new Projectcoc();
       model.setProjectcocId(entity.getId());
       model.setCoccode(entity.getCoccode());
       return model;
   }


}