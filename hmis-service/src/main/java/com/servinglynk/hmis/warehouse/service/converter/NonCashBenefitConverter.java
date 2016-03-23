package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.NonCashBenefit;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsBenefitsfromanysourceEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsOthersourceEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsOthertanfEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsRentalassistanceongoingEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsRentalassistancetempEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsSnapEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsTanfchildcareEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsTanftransportationEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsWicEnum;
public class NonCashBenefitConverter extends BaseConveter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Noncashbenefits modelToEntity (NonCashBenefit model ,com.servinglynk.hmis.warehouse.model.v2014.Noncashbenefits entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Noncashbenefits();
       if(model.getNonCashBenefitId()!=null)
       entity.setId(model.getNonCashBenefitId());
       if(model.getOthersource()!=null)
       entity.setOthersource(NoncashbenefitsOthersourceEnum.lookupEnum(model.getOthersource().toString()));
       if(model.getOthersourceidentify()!=null)
       entity.setOthersourceidentify(model.getOthersourceidentify());
       if(model.getOthertanf()!=null)
       entity.setOthertanf(NoncashbenefitsOthertanfEnum.lookupEnum(model.getOthertanf().toString()));
       if(model.getRentalassistanceongoing()!=null)
       entity.setRentalassistanceongoing(NoncashbenefitsRentalassistanceongoingEnum.lookupEnum(model.getRentalassistanceongoing().toString()));
       if(model.getRentalassistancetemp()!=null)
       entity.setRentalassistancetemp(NoncashbenefitsRentalassistancetempEnum.lookupEnum(model.getRentalassistancetemp().toString()));
       if(model.getSnap()!=null)
       entity.setSnap(NoncashbenefitsSnapEnum.lookupEnum(model.getSnap().toString()));
       if(model.getTanfchildcare()!=null)
       entity.setTanfchildcare(NoncashbenefitsTanfchildcareEnum.lookupEnum(model.getTanfchildcare().toString()));
       if(model.getTanftransportation()!=null)
       entity.setTanftransportation(NoncashbenefitsTanftransportationEnum.lookupEnum(model.getTanftransportation().toString()));
       if(model.getWic()!=null)
       entity.setWic(NoncashbenefitsWicEnum.lookupEnum(model.getWic().toString()));
       if(model.getBenefitsfromanysource()!=null)
       entity.setBenefitsfromanysource(NoncashbenefitsBenefitsfromanysourceEnum.lookupEnum(model.getBenefitsfromanysource().toString()));
       return entity;    
   }


   public static NonCashBenefit entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Noncashbenefits entity) {
       NonCashBenefit model = new NonCashBenefit();
       if(entity.getId()!=null)
       model.setNonCashBenefitId(entity.getId());
       if(entity.getOthersource()!=null)
       model.setOthersource(Integer.parseInt(entity.getOthersource().getValue()));
       if(entity.getOthersourceidentify()!=null)
       model.setOthersourceidentify(entity.getOthersourceidentify());
       if(entity.getOthertanf()!=null)
       model.setOthertanf(Integer.parseInt(entity.getOthertanf().getValue()));
       if(entity.getRentalassistanceongoing()!=null)
       model.setRentalassistanceongoing(Integer.parseInt(entity.getRentalassistanceongoing().getValue()));
       if(entity.getRentalassistancetemp()!=null)
       model.setRentalassistancetemp(Integer.parseInt(entity.getRentalassistancetemp().getValue()));
       if(entity.getSnap()!=null)
       model.setSnap(Integer.parseInt(entity.getSnap().getValue()));
       if(entity.getTanfchildcare()!=null)
       model.setTanfchildcare(Integer.parseInt(entity.getTanfchildcare().getValue()));
       if(entity.getTanftransportation()!=null)
       model.setTanftransportation(Integer.parseInt(entity.getTanftransportation().getValue()));
       if(entity.getWic()!=null)
       model.setWic(Integer.parseInt(entity.getWic().getValue()));
       if(entity.getBenefitsfromanysource()!=null)
       model.setBenefitsfromanysource(Integer.parseInt(entity.getBenefitsfromanysource().getValue()));
       copyBeanProperties(entity, model);
       return model;
   }


}
