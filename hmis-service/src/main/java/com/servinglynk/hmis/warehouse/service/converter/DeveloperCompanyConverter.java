package com.servinglynk.hmis.warehouse.service.converter;

import com.servinglynk.hmis.warehouse.common.ValidationUtil;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.DeveloperCompany;


public class DeveloperCompanyConverter {
	/**
	 * Convert to {@link com.servinglynk.hmis.warehouse.model.v2014.DeveloperCompanyEntity.hn.cs.core.model.DeveloperCompany}.
	 * @param pDeveloperCompany {@link com.servinglynk.hmis.warehouse.model.v2014.DeveloperCompanyEntity.hn.cs.persistence.model.DeveloperCompany} to convert from
	 * @return converted {@link com.servinglynk.hmis.warehouse.model.v2014.DeveloperCompanyEntity.hn.cs.core.model.DeveloperCompany}
	 */
	public static DeveloperCompany convertToDeveloperCompany(com.servinglynk.hmis.warehouse.model.v2014.DeveloperCompanyEntity pDeveloperCompany) {
		DeveloperCompany developerCompany = new DeveloperCompany();
		
		developerCompany.setDeveloperCompanyId(pDeveloperCompany.getExternalId());
		developerCompany.setName(pDeveloperCompany.getName());
		developerCompany.setDomain(pDeveloperCompany.getDomain());
		developerCompany.setLogoUrl(pDeveloperCompany.getLogoUrl());
		Account owner = new Account();
		owner.setFirstName(pDeveloperCompany.getAccount().getFirstName());
		owner.setLastName(pDeveloperCompany.getAccount().getLastName());
		owner.setUsername(pDeveloperCompany.getAccount().getUsername());
		developerCompany.setOwner(owner);
		
	}
	
	/**
	 * Convert to {@link com.servinglynk.hmis.warehouse.model.v2014.DeveloperCompanyEntity.hn.cs.persistence.model.DeveloperCompany}.
	 * 
	 * @param developerCompany {@link com.servinglynk.hmis.warehouse.model.v2014.DeveloperCompanyEntity.hn.cs.core.model.DeveloperCompany} to convert from
	 * @param pDeveloperCompany {@link com.servinglynk.hmis.warehouse.model.v2014.DeveloperCompanyEntity.hn.cs.persistence.model.DeveloperCompany} to convert to
	 * @return converted {@link com.servinglynk.hmis.warehouse.model.v2014.DeveloperCompanyEntity.hn.cs.persistence.model.DeveloperCompany}
	 */
	public static com.servinglynk.hmis.warehouse.model.v2014.DeveloperCompanyEntity convertToPersistentDeveloperCompany(DeveloperCompany developerCompany, com.servinglynk.hmis.warehouse.model.v2014.DeveloperCompanyEntity pDeveloperCompany) {
		if (pDeveloperCompany == null) {
			pDeveloperCompany = new com.servinglynk.hmis.warehouse.model.v2014.DeveloperCompanyEntity();
		}
		if (ValidationUtil.isNotNull(developerCompany.getName())) {
			pDeveloperCompany.setName(developerCompany.getName());
		}
		if (ValidationUtil.isNotNull(developerCompany.getDomain())) {
			pDeveloperCompany.setDomain(developerCompany.getDomain());
		}
		if (ValidationUtil.isNotNull(developerCompany.getLogoUrl())) {
			pDeveloperCompany.setLogoUrl(developerCompany.getLogoUrl());
		}
	}
	
	public static com.servinglynk.hmis.warehouse.model.v2014.DeveloperCompanyEntity convertSimpleToPersistentDeveloperCompany(DeveloperCompany developerCompany, com.servinglynk.hmis.warehouse.model.v2014.DeveloperCompanyEntity pDeveloperCompany) {

		if (ValidationUtil.isNotNull(developerCompany.getDomain())) {
			pDeveloperCompany.setDomain(developerCompany.getDomain());
		}
		return pDeveloperCompany;
	}
}