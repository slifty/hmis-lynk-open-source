package com.servinglynk.hmis.warehouse.client.model;

import com.fasterxml.jackson.annotation.JsonRootName;


@JsonRootName("apiMethodAuthorizationCheck")
public class ApiMethodAuthorizationCheck extends ClientModel {
	
	private String trustedAppId;
	

	private String accessToken;
	
	private String apiMethodId;
	
	private Account account;
	
	private Boolean checkSessionToken=null;

	public String getTrustedAppId() {
		return trustedAppId;
	}
	public void setTrustedAppId(String trustedAppId) {
		this.trustedAppId = trustedAppId;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getApiMethodId() {
		return apiMethodId;
	}
	public void setApiMethodId(String apiMethodId) {
		this.apiMethodId = apiMethodId;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	public Boolean getCheckSessionToken() {
		return checkSessionToken;
	}
	public void setCheckSessionToken(Boolean checkSessionToken) {
		this.checkSessionToken = checkSessionToken;
	}

}
