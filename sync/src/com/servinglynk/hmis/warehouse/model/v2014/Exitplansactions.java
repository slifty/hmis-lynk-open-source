package com.servinglynk.hmis.warehouse.model.v2014;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Exitplansactions extends BaseModel {

	@Column(name = "assistancemainstreambenefits")
	public String assistancemainstreambenefits;
	@Column(name = "exitcounseling")
	public String exitcounseling;
	@Column(name = "exitid")
	public UUID exitid;
	@Column(name = "furtherfollowupservices")
	public String furtherfollowupservices;
	@Column(name = "otheraftercareplanoraction")
	public String otheraftercareplanoraction;
	@Column(name = "permanenthousingplacement")
	public String permanenthousingplacement;
	@Column(name = "resourcepackage")
	public String resourcepackage;
	@Column(name = "scheduledfollowupcontacts")
	public String scheduledfollowupcontacts;
	@Column(name = "temporaryshelterplacement")
	public String temporaryshelterplacement;
	@Column(name = "writtenaftercareplan")
	public String writtenaftercareplan;

	/**
	 * @return the assistancemainstreambenefits
	 */
	public String getAssistancemainstreambenefits() {
		return assistancemainstreambenefits;
	}

	/**
	 * @param assistancemainstreambenefits
	 *            the assistancemainstreambenefits to set
	 */
	public void setAssistancemainstreambenefits(
			String assistancemainstreambenefits) {
		this.assistancemainstreambenefits = assistancemainstreambenefits;
	}

	/**
	 * @return the exitcounseling
	 */
	public String getExitcounseling() {
		return exitcounseling;
	}

	/**
	 * @param exitcounseling
	 *            the exitcounseling to set
	 */
	public void setExitcounseling(String exitcounseling) {
		this.exitcounseling = exitcounseling;
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
	 * @return the furtherfollowupservices
	 */
	public String getFurtherfollowupservices() {
		return furtherfollowupservices;
	}

	/**
	 * @param furtherfollowupservices
	 *            the furtherfollowupservices to set
	 */
	public void setFurtherfollowupservices(String furtherfollowupservices) {
		this.furtherfollowupservices = furtherfollowupservices;
	}

	/**
	 * @return the otheraftercareplanoraction
	 */
	public String getOtheraftercareplanoraction() {
		return otheraftercareplanoraction;
	}

	/**
	 * @param otheraftercareplanoraction
	 *            the otheraftercareplanoraction to set
	 */
	public void setOtheraftercareplanoraction(String otheraftercareplanoraction) {
		this.otheraftercareplanoraction = otheraftercareplanoraction;
	}

	/**
	 * @return the permanenthousingplacement
	 */
	public String getPermanenthousingplacement() {
		return permanenthousingplacement;
	}

	/**
	 * @param permanenthousingplacement
	 *            the permanenthousingplacement to set
	 */
	public void setPermanenthousingplacement(String permanenthousingplacement) {
		this.permanenthousingplacement = permanenthousingplacement;
	}

	/**
	 * @return the resourcepackage
	 */
	public String getResourcepackage() {
		return resourcepackage;
	}

	/**
	 * @param resourcepackage
	 *            the resourcepackage to set
	 */
	public void setResourcepackage(String resourcepackage) {
		this.resourcepackage = resourcepackage;
	}

	/**
	 * @return the scheduledfollowupcontacts
	 */
	public String getScheduledfollowupcontacts() {
		return scheduledfollowupcontacts;
	}

	/**
	 * @param scheduledfollowupcontacts
	 *            the scheduledfollowupcontacts to set
	 */
	public void setScheduledfollowupcontacts(String scheduledfollowupcontacts) {
		this.scheduledfollowupcontacts = scheduledfollowupcontacts;
	}

	/**
	 * @return the temporaryshelterplacement
	 */
	public String getTemporaryshelterplacement() {
		return temporaryshelterplacement;
	}

	/**
	 * @param temporaryshelterplacement
	 *            the temporaryshelterplacement to set
	 */
	public void setTemporaryshelterplacement(String temporaryshelterplacement) {
		this.temporaryshelterplacement = temporaryshelterplacement;
	}

	/**
	 * @return the writtenaftercareplan
	 */
	public String getWrittenaftercareplan() {
		return writtenaftercareplan;
	}

	/**
	 * @param writtenaftercareplan
	 *            the writtenaftercareplan to set
	 */
	public void setWrittenaftercareplan(String writtenaftercareplan) {
		this.writtenaftercareplan = writtenaftercareplan;
	}

}