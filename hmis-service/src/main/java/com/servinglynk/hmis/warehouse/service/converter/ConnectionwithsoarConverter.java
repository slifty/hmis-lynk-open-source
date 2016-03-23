package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.Connectionwithsoar;
public class ConnectionwithsoarConverter extends BaseConveter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Connectionwithsoar modelToEntity (Connectionwithsoar model ,com.servinglynk.hmis.warehouse.model.v2014.Connectionwithsoar entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Connectionwithsoar();
       if(model.getConnectionwithsoarId()!=null)
       entity.setId(model.getConnectionwithsoarId());
       if(model.getConnectionwithsoar()!=null)
       entity.setConnectionwithsoar(model.getConnectionwithsoar());
       return entity;    
   }


   public static Connectionwithsoar entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Connectionwithsoar entity) {
       Connectionwithsoar model = new Connectionwithsoar();
       if(entity.getId()!=null)
       model.setConnectionwithsoarId(entity.getId());
       if(entity.getConnectionwithsoar()!=null)
       model.setConnectionwithsoar(entity.getConnectionwithsoar());
       copyBeanProperties(entity, model);
       return model;
   }


}
