package com.servinglynk.hmis.warehouse.client.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@SuppressWarnings("serial")
public class JSONObjectMapper extends ObjectMapper{
	public JSONObjectMapper() {
		super();
		this.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
		this.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
        this.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        this.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
	}
}
