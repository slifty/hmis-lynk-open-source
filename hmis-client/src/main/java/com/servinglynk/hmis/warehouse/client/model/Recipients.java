package com.servinglynk.hmis.warehouse.client.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("recipients")
public class Recipients extends ClientModel {
	
	List<String> toRecipients=new ArrayList<String>();
	List<String> bccRecipients=new ArrayList<String>();
	List<String> ccRecipients=new ArrayList<String>();
	public List<String> getToRecipients() {
		return toRecipients;
	}
	public void setToRecipients(List<String> toRecipients) {
		this.toRecipients = toRecipients;
	}
	public List<String> getBccRecipients() {
		return bccRecipients;
	}
	public void setBccRecipients(List<String> bccRecipients) {
		this.bccRecipients = bccRecipients;
	}
	public List<String> getCcRecipients() {
		return ccRecipients;
	}
	public void setCcRecipients(List<String> ccRecipients) {
		this.ccRecipients = ccRecipients;
	}
	
	public void addToRecipient(String toRecipient){
		this.toRecipients.add(toRecipient);
	}
	public void addBccRecipient(String bccRecipient){
		this.bccRecipients.add(bccRecipient);
	}
	public void addCcRecipient(String ccRecipient){
		this.ccRecipients.add(ccRecipient);
	}
}
