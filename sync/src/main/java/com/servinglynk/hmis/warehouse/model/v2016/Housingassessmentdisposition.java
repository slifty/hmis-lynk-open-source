package com.servinglynk.hmis.warehouse.model.v2016;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.servinglynk.hmis.warehouse.BaseModel;

@Entity
public class Housingassessmentdisposition extends BaseModel {

	@Column(name = "assessmentdisposition")
	public String assessmentdisposition;
	@Column(name = "exitid")
	public UUID exitid;
	@Column(name = "otherdisposition")
	public String otherdisposition;
	@Column(name = "id")
	public UUID id;
	
	

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	/**
	 * @return the assessmentdisposition
	 */
	public String getAssessmentdisposition() {
		return assessmentdisposition;
	}

	/**
	 * @param assessmentdisposition
	 *            the assessmentdisposition to set
	 */
	public void setAssessmentdisposition(String assessmentdisposition) {
		this.assessmentdisposition = assessmentdisposition;
	}

	/**
	 * @return the exitid
	 */
	public UUID getExitid() {
		return exitid;
	}

	/**
	 * @param exitid
	 *            the exitid to set
	 */
	public void setExitid(UUID exitid) {
		this.exitid = exitid;
	}

	/**
	 * @return the otherdisposition
	 */
	public String getOtherdisposition() {
		return otherdisposition;
	}

	/**
	 * @param otherdisposition
	 *            the otherdisposition to set
	 */
	public void setOtherdisposition(String otherdisposition) {
		this.otherdisposition = otherdisposition;
	}

}
