package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.Servicefareferral;
public class ServicefareferralConverter  extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2015.ServiceFaReferral modelToEntity (Servicefareferral model ,com.servinglynk.hmis.warehouse.model.v2015.ServiceFaReferral entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2015.ServiceFaReferral();
       entity.setId(model.getServicefareferralId());
       entity.setDateprovided(model.getDateprovided());
       entity.setServiceCategory(model.getServiceCategory());
       entity.setFunderList(model.getFunderList());
       entity.setTypeProvided(model.getTypeProvided());
       entity.setOtherTypeProvided(model.getOtherTypeProvided());
       entity.setSubTypeProvided(model.getSubTypeProvided());
       entity.setFaAmount(model.getFaAmount());
       entity.setReferralOutcome(model.getReferralOutcome());
       return entity;    
   }


   public static Servicefareferral entityToModel (com.servinglynk.hmis.warehouse.model.v2015.ServiceFaReferral entity) {
       Servicefareferral model = new Servicefareferral();
       model.setServicefareferralId(entity.getId());
       model.setDateprovided(entity.getDateprovided());
       model.setServiceCategory(entity.getServiceCategory());
       model.setFunderList(entity.getFunderList());
       model.setTypeProvided(entity.getTypeProvided());
       model.setOtherTypeProvided(entity.getOtherTypeProvided());
       model.setSubTypeProvided(entity.getSubTypeProvided());
       model.setFaAmount(entity.getFaAmount());
       model.setReferralOutcome(entity.getReferralOutcome());
       return model;
   }


}
