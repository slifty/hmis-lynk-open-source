package com.servinglynk.hmis.warehouse.model.v2014;

import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.servinglynk.hmis.warehouse.BaseModel;

@Entity
public class Medicalassistance extends BaseModel {

	@Column(name = "adap")			
	public String  adap;
	@Column(name = "hivaidsassistance")
	public String  hivaidsassistance;
	@Column(name = "noadapreason")
	public String  noadapreason;
	@Column(name = "nohivaidsassistancereason")
	public String  nohivaidsassistancereason;
	@Column(name = "enrollmentid")
	public UUID  enrollmentid;
	@Column(name="datacollectionstage")
	public String datacollectionstage;
	@Column(name="information_date")
	private Date information_date;
	
	/**
	 * @return the datacollectionstage
	 */
	public String getDatacollectionstage() {
		return datacollectionstage;
	}
	/**
	 * @param datacollectionstage the datacollectionstage to set
	 */
	public void setDatacollectionstage(String datacollectionstage) {
		this.datacollectionstage = datacollectionstage;
	}
	/**
	 * @return the information_date
	 */
	public Date getInformation_date() {
		return information_date;
	}
	/**
	 * @param information_date the information_date to set
	 */
	public void setInformation_date(Date information_date) {
		this.information_date = information_date;
	}
	/**
	 * @return the adap
	 */
	public String getAdap() {
		return adap;
	}
	/**
	 * @param adap the adap to set
	 */
	public void setAdap(String adap) {
		this.adap = adap;
	}
	/**
	 * @return the hivaidsassistance
	 */
	public String getHivaidsassistance() {
		return hivaidsassistance;
	}
	/**
	 * @param hivaidsassistance the hivaidsassistance to set
	 */
	public void setHivaidsassistance(String hivaidsassistance) {
		this.hivaidsassistance = hivaidsassistance;
	}
	/**
	 * @return the noadapreason
	 */
	public String getNoadapreason() {
		return noadapreason;
	}
	/**
	 * @param noadapreason the noadapreason to set
	 */
	public void setNoadapreason(String noadapreason) {
		this.noadapreason = noadapreason;
	}
	/**
	 * @return the nohivaidsassistancereason
	 */
	public String getNohivaidsassistancereason() {
		return nohivaidsassistancereason;
	}
	/**
	 * @param nohivaidsassistancereason the nohivaidsassistancereason to set
	 */
	public void setNohivaidsassistancereason(String nohivaidsassistancereason) {
		this.nohivaidsassistancereason = nohivaidsassistancereason;
	}
	/**
	 * @return the enrollmentid
	 */
	public UUID getEnrollmentid() {
		return enrollmentid;
	}
	/**
	 * @param enrollmentid the enrollmentid to set
	 */
	public void setEnrollmentid(UUID enrollmentid) {
		this.enrollmentid = enrollmentid;
	}
	
	
}
