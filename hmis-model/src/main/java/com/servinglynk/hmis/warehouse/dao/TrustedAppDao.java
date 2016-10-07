package com.servinglynk.hmis.warehouse.dao;

import com.servinglynk.hmis.warehouse.model.v2014.TrustedAppEntity;

public interface TrustedAppDao {
	
	public TrustedAppEntity updateTrustedApp(TrustedAppEntity trustedAppEntity);
	
	public TrustedAppEntity findByExternalId(String externalId);
	
	public void deleteTrustedApp(TrustedAppEntity trustedAppEntity);

	public void create(TrustedAppEntity trustedAppEntity);

}