package com.servinglynk.hmis.warehouse.core.web.interceptor;import com.servinglynk.hmis.warehouse.core.model.ApiMethodAuthorizationCheck;import com.servinglynk.hmis.warehouse.core.model.Session;public interface ApiAuthChecker {	public ApiMethodAuthorizationCheck checkApiAuth(String trustedAppId, String accessToken, String apiMethodId, Boolean isSessionTokenCheckRequired);		 boolean checkApiAuthForUser(Session session, String apiMethodId);}