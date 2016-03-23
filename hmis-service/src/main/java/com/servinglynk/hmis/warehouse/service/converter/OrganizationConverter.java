package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.Organization;
public class OrganizationConverter extends BaseConveter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Organization modelToEntity (Organization model ,com.servinglynk.hmis.warehouse.model.v2014.Organization entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Organization();
       if(model.getOrganizationCommonName()!=null)
       entity.setOrganizationcommonname(model.getOrganizationCommonName());
       if(model.getOrganizationName()!=null)
       entity.setOrganizationname(model.getOrganizationName());
       return entity;    
   }


   public static Organization entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Organization entity) {
       Organization organization= new Organization();
       if(entity.getOrganizationcommonname()!=null)
       organization.setOrganizationCommonName(entity.getOrganizationcommonname());
       if(entity.getId()!=null)
       organization.setOrganizationId(entity.getId());
       if(organization.getOrganizationName()!=null)
       organization.setOrganizationName(organization.getOrganizationName());
       copyBeanProperties(entity, organization);
       return organization;
   }


}
