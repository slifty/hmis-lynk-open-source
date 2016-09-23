package com.servinglynk.hmis.warehouse.model.v2016;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;
import org.hibernate.proxy.HibernateProxy;

import com.servinglynk.hmis.warehouse.enums.AnnualpercentamiEnum;
import com.servinglynk.hmis.warehouse.enums.CrisisServicesUseEnum;
import com.servinglynk.hmis.warehouse.enums.EntrySSVFPercentAMIEnum;
import com.servinglynk.hmis.warehouse.enums.EvictionhistoryEnum;
import com.servinglynk.hmis.warehouse.enums.LiteralHomelessHistoryEnum;
import com.servinglynk.hmis.warehouse.enums.NoYesENum;
import com.servinglynk.hmis.warehouse.enums.TimeToHousingLossEnum;


/** 
 * Object mapping for hibernate-handled table: entryssvf.
 * 
 *
 * @author autogenerated
 */
		

@Entity (name = "entryssvf_v2015")
@Table(name = "entryssvf", catalog = "hmis", schema = "v2015")
public class Entryssvf extends HmisBaseModel implements Cloneable, Serializable {

	/** Serial Version UID. */
	private static final long serialVersionUID = -8876535059279041235L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities 
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, java.util.UUID> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, java.util.UUID>());
	
	/** hashCode temporary storage. */
	private volatile java.util.UUID hashCode;
	

	/** Field mapping. */
	private Integer addressDataQuality;
	/** Field mapping. */
	/** Field mapping. */
	private Enrollment enrollmentid;
	/** Field mapping. */
	private Integer hpScreeningScore;
	/** Field mapping. */
	private java.util.UUID id;
	/** Field mapping. */
	private String lastPermanentCity;
	/** Field mapping. */
	private String lastPermanentState;
	/** Field mapping. */
	private String lastPermanentStreet;
	/** Field mapping. */
	private String lastPermanentZip;
	/** Field mapping. */
	private EntrySSVFPercentAMIEnum percentami;
	/** Field mapping. */
	private String vamcStation;
	private TimeToHousingLossEnum timeToHousingLoss;
	private NoYesENum zeroincome;
	private AnnualpercentamiEnum annualpercentami;
	private NoYesENum financialchange;
	private NoYesENum householdchange;
	private EvictionhistoryEnum evictionhistory;
	private NoYesENum subsidyatrisk;
	private LiteralHomelessHistoryEnum literalhomelesshistory;
	private NoYesENum disablehoh;
	private NoYesENum criminalrecord;
	private NoYesENum sexoffender;
	private NoYesENum dependendunder6;
	private NoYesENum singleparent;
	private NoYesENum hh5plus;
	private NoYesENum iraqafghanistan;
	private NoYesENum femvet;
	private Integer thresholdscore;
	private CrisisServicesUseEnum ervisits;
	private CrisisServicesUseEnum jailnights;
	private CrisisServicesUseEnum hospitalnights;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public Entryssvf() {
		// Default constructor
	} 

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public Entryssvf(java.util.UUID id) {
		this.id = id;
	}
	
 


 
	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Transient
	public Class<?> getClassType() {
		return Entryssvf.class;
	}
 

	 /**
	 * Return the value associated with the column: addressDataQuality.
	 * @return A Integer object (this.addressDataQuality)
	 */
	@Basic( optional = true )
	@Column( name = "address_data_quality"  )
	public Integer getAddressDataQuality() {
		return this.addressDataQuality;
		
	}
	

  
	 /**  
	 * Set the value related to the column: addressDataQuality.
	 * @param addressDataQuality the addressDataQuality value you wish to set
	 */
	public void setAddressDataQuality(final Integer addressDataQuality) {
		this.addressDataQuality = addressDataQuality;
	}

	 /**
	 * Return the value associated with the column: enrollmentid.
	 * @return A Enrollment object (this.enrollmentid)
	 */
	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = true )
	@JoinColumn(name = "enrollmentid", nullable = true )
	public Enrollment getEnrollmentid() {
		return this.enrollmentid;
		
	}
	

  
	 /**  
	 * Set the value related to the column: enrollmentid.
	 * @param enrollmentid the enrollmentid value you wish to set
	 */
	public void setEnrollmentid(final Enrollment enrollmentid) {
		this.enrollmentid = enrollmentid;
	}

	 /**
	 * Return the value associated with the column: hpScreenScore.
	 * @return A Integer object (this.hpScreenScore)
	 */
	@Basic( optional = true )
	@Column( name = "hp_screen_score"  )
	public Integer getHpScreeningScore() {
		return this.hpScreeningScore;
		
	}
	
	 /**  
	 * Set the value related to the column: hpScreeningScore.
	 * @param hpScreenScore the hpScreenScore value you wish to set
	 */
	public void setHpScreeningScore(final Integer hpScreeningScore) {
		this.hpScreeningScore = hpScreeningScore;
	}

	 /**
	 * Return the value associated with the column: id.
	 * @return A java.util.UUID object (this.id)
	 */
	@Id 
	@Basic( optional = false )
    @Column( name = "id", nullable = false  ) @org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	public java.util.UUID getId() {
		return this.id;
		
	}
	

  
	 /**  
	 * Set the value related to the column: id.
	 * @param id the id value you wish to set
	 */
	public void setId(final java.util.UUID id) {
		// If we've just been persisted and hashCode has been
		// returned then make sure other entities with this
		// ID return the already returned hash code
		if ( (this.id == null ) &&
				(id != null) &&
				(this.hashCode != null) ) {
		SAVED_HASHES.put( id, this.hashCode );
		}
		this.id = id;
	}

	 /**
	 * Return the value associated with the column: lastPermanentCity.
	 * @return A String object (this.lastPermanentCity)
	 */
	@Basic( optional = true )
	@Column( name = "last_permanent_city", length = 50  )
	public String getLastPermanentCity() {
		return this.lastPermanentCity;
		
	}
	

  
	 /**  
	 * Set the value related to the column: lastPermanentCity.
	 * @param lastPermanentCity the lastPermanentCity value you wish to set
	 */
	public void setLastPermanentCity(final String lastPermanentCity) {
		this.lastPermanentCity = lastPermanentCity;
	}

	 /**
	 * Return the value associated with the column: lastPermanentState.
	 * @return A String object (this.lastPermanentState)
	 */
	@Basic( optional = true )
	@Column( name = "last_permanent_state", length = 50  )
	public String getLastPermanentState() {
		return this.lastPermanentState;
		
	}
	

  
	 /**  
	 * Set the value related to the column: lastPermanentState.
	 * @param lastPermanentState the lastPermanentState value you wish to set
	 */
	public void setLastPermanentState(final String lastPermanentState) {
		this.lastPermanentState = lastPermanentState;
	}

	 /**
	 * Return the value associated with the column: lastPermanentStreet.
	 * @return A String object (this.lastPermanentStreet)
	 */
	@Basic( optional = true )
	@Column( name = "last_permanent_street", length = 50  )
	public String getLastPermanentStreet() {
		return this.lastPermanentStreet;
		
	}
	

  
	 /**  
	 * Set the value related to the column: lastPermanentStreet.
	 * @param lastPermanentStreet the lastPermanentStreet value you wish to set
	 */
	public void setLastPermanentStreet(final String lastPermanentStreet) {
		this.lastPermanentStreet = lastPermanentStreet;
	}

	 /**
	 * Return the value associated with the column: lastPermanentZip.
	 * @return A String object (this.lastPermanentZip)
	 */
	@Basic( optional = true )
	@Column( name = "last_permanent_zip", length = 50  )
	public String getLastPermanentZip() {
		return this.lastPermanentZip;
		
	}
	

  
	 /**  
	 * Set the value related to the column: lastPermanentZip.
	 * @param lastPermanentZip the lastPermanentZip value you wish to set
	 */
	public void setLastPermanentZip(final String lastPermanentZip) {
		this.lastPermanentZip = lastPermanentZip;
	}

	/**
	 * Return the value associated with the column: percentami.
	 * @return A Integer object (this.percentami)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.EntrySSVFPercentAMIEnumType")
	@Basic( optional = true )
	@Column (name="percentAMI")
	public EntrySSVFPercentAMIEnum getPercentami() {
		return this.percentami;

	}



	 /**
	 * Set the value related to the column: percentami.
	 * @param percentami the percentami value you wish to set
	 */
	public void setPercentami(final EntrySSVFPercentAMIEnum percentami) {
		this.percentami = percentami;
	}

	 /**
	 * Return the value associated with the column: vamcStation.
	 * @return A String object (this.vamcStation)
	 */
	@Basic( optional = true )
	@Column( name = "vamc_staction", length = 50  )
	public String getVamcStation() {
		return this.vamcStation;
		
	}
	

  
	 /**  
	 * Set the value related to the column: vamcStation.
	 * @param vamcStation the vamcStaction value you wish to set
	 */
	public void setVamcStation(final String vamcStation) {
		this.vamcStation = vamcStation;
	}

	/** Field mapping. */
	protected Export export;
	 /**
	 * Return the value associated with the column: export.
	 * @return A Export object (this.export)
	 */
	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = true )
	@JoinColumn(name = "export_id", nullable = true )
	public Export getExport() {
		return this.export;
		
	}
	

 
	 /**  
	 * Set the value related to the column: export.
	 * @param export the export value you wish to set
	 */
	public void setExport(final Export export) {
		this.export = export;
	}
	
   /**
	 * @return the timeToHousingLoss
	 */
	public TimeToHousingLossEnum getTimeToHousingLoss() {
		return timeToHousingLoss;
	}

	/**
	 * @param timeToHousingLoss the timeToHousingLoss to set
	 */
	public void setTimeToHousingLoss(TimeToHousingLossEnum timeToHousingLoss) {
		this.timeToHousingLoss = timeToHousingLoss;
	}

	/**
	 * @return the zeroincome
	 */
	public NoYesENum getZeroincome() {
		return zeroincome;
	}

	/**
	 * @param zeroincome the zeroincome to set
	 */
	public void setZeroincome(NoYesENum zeroincome) {
		this.zeroincome = zeroincome;
	}

	/**
	 * @return the annualpercentami
	 */
	public AnnualpercentamiEnum getAnnualpercentami() {
		return annualpercentami;
	}

	/**
	 * @param annualpercentami the annualpercentami to set
	 */
	public void setAnnualpercentami(AnnualpercentamiEnum annualpercentami) {
		this.annualpercentami = annualpercentami;
	}

	/**
	 * @return the financialchange
	 */
	public NoYesENum getFinancialchange() {
		return financialchange;
	}

	/**
	 * @param financialchange the financialchange to set
	 */
	public void setFinancialchange(NoYesENum financialchange) {
		this.financialchange = financialchange;
	}

	/**
	 * @return the householdchange
	 */
	public NoYesENum getHouseholdchange() {
		return householdchange;
	}

	/**
	 * @param householdchange the householdchange to set
	 */
	public void setHouseholdchange(NoYesENum householdchange) {
		this.householdchange = householdchange;
	}

	/**
	 * @return the evictionhistory
	 */
	public EvictionhistoryEnum getEvictionhistory() {
		return evictionhistory;
	}

	/**
	 * @param evictionhistory the evictionhistory to set
	 */
	public void setEvictionhistory(EvictionhistoryEnum evictionhistory) {
		this.evictionhistory = evictionhistory;
	}

	/**
	 * @return the subsidyatrisk
	 */
	public NoYesENum getSubsidyatrisk() {
		return subsidyatrisk;
	}

	/**
	 * @param subsidyatrisk the subsidyatrisk to set
	 */
	public void setSubsidyatrisk(NoYesENum subsidyatrisk) {
		this.subsidyatrisk = subsidyatrisk;
	}

	/**
	 * @return the literalhomelesshistory
	 */
	public LiteralHomelessHistoryEnum getLiteralhomelesshistory() {
		return literalhomelesshistory;
	}

	/**
	 * @param literalhomelesshistory the literalhomelesshistory to set
	 */
	public void setLiteralhomelesshistory(
			LiteralHomelessHistoryEnum literalhomelesshistory) {
		this.literalhomelesshistory = literalhomelesshistory;
	}

	/**
	 * @return the disablehoh
	 */
	public NoYesENum getDisablehoh() {
		return disablehoh;
	}

	/**
	 * @param disablehoh the disablehoh to set
	 */
	public void setDisablehoh(NoYesENum disablehoh) {
		this.disablehoh = disablehoh;
	}

	/**
	 * @return the criminalrecord
	 */
	public NoYesENum getCriminalrecord() {
		return criminalrecord;
	}

	/**
	 * @param criminalrecord the criminalrecord to set
	 */
	public void setCriminalrecord(NoYesENum criminalrecord) {
		this.criminalrecord = criminalrecord;
	}

	/**
	 * @return the sexoffender
	 */
	public NoYesENum getSexoffender() {
		return sexoffender;
	}

	/**
	 * @param sexoffender the sexoffender to set
	 */
	public void setSexoffender(NoYesENum sexoffender) {
		this.sexoffender = sexoffender;
	}

	/**
	 * @return the dependendunder6
	 */
	public NoYesENum getDependendunder6() {
		return dependendunder6;
	}

	/**
	 * @param dependendunder6 the dependendunder6 to set
	 */
	public void setDependendunder6(NoYesENum dependendunder6) {
		this.dependendunder6 = dependendunder6;
	}

	/**
	 * @return the singleparent
	 */
	public NoYesENum getSingleparent() {
		return singleparent;
	}

	/**
	 * @param singleparent the singleparent to set
	 */
	public void setSingleparent(NoYesENum singleparent) {
		this.singleparent = singleparent;
	}

	/**
	 * @return the hh5plus
	 */
	public NoYesENum getHh5plus() {
		return hh5plus;
	}

	/**
	 * @param hh5plus the hh5plus to set
	 */
	public void setHh5plus(NoYesENum hh5plus) {
		this.hh5plus = hh5plus;
	}

	/**
	 * @return the iraqafghanistan
	 */
	public NoYesENum getIraqafghanistan() {
		return iraqafghanistan;
	}

	/**
	 * @param iraqafghanistan the iraqafghanistan to set
	 */
	public void setIraqafghanistan(NoYesENum iraqafghanistan) {
		this.iraqafghanistan = iraqafghanistan;
	}

	/**
	 * @return the femvet
	 */
	public NoYesENum getFemvet() {
		return femvet;
	}

	/**
	 * @param femvet the femvet to set
	 */
	public void setFemvet(NoYesENum femvet) {
		this.femvet = femvet;
	}

	/**
	 * @return the thresholdscore
	 */
	public Integer getThresholdscore() {
		return thresholdscore;
	}

	/**
	 * @param thresholdscore the thresholdscore to set
	 */
	public void setThresholdscore(Integer thresholdscore) {
		this.thresholdscore = thresholdscore;
	}

	/**
	 * @return the ervisits
	 */
	public CrisisServicesUseEnum getErvisits() {
		return ervisits;
	}

	/**
	 * @param ervisits the ervisits to set
	 */
	public void setErvisits(CrisisServicesUseEnum ervisits) {
		this.ervisits = ervisits;
	}

	/**
	 * @return the jailnights
	 */
	public CrisisServicesUseEnum getJailnights() {
		return jailnights;
	}

	/**
	 * @param jailnights the jailnights to set
	 */
	public void setJailnights(CrisisServicesUseEnum jailnights) {
		this.jailnights = jailnights;
	}

	/**
	 * @return the hospitalnights
	 */
	public CrisisServicesUseEnum getHospitalnights() {
		return hospitalnights;
	}

	/**
	 * @param hospitalnights the hospitalnights to set
	 */
	public void setHospitalnights(CrisisServicesUseEnum hospitalnights) {
		this.hospitalnights = hospitalnights;
	}

/**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public Entryssvf clone() throws CloneNotSupportedException {
		
        final Entryssvf copy = (Entryssvf)super.clone();

		copy.setAddressDataQuality(this.getAddressDataQuality());
		copy.setDateCreated(this.getDateCreated());
		copy.setDateCreatedFromSource(this.getDateCreatedFromSource());
		copy.setDateUpdated(this.getDateUpdated());
		copy.setDateUpdatedFromSource(this.getDateUpdatedFromSource());
		copy.setDeleted(this.isDeleted());
		copy.setEnrollmentid(this.getEnrollmentid());
		copy.setExport(this.getExport());
		copy.setHpScreeningScore(this.getHpScreeningScore());
		copy.setId(this.getId());
		copy.setLastPermanentCity(this.getLastPermanentCity());
		copy.setLastPermanentState(this.getLastPermanentState());
		copy.setLastPermanentStreet(this.getLastPermanentStreet());
		copy.setLastPermanentZip(this.getLastPermanentZip());
		copy.setParentId(this.getParentId());
		copy.setPercentami(this.getPercentami());
		copy.setProjectGroupCode(this.getProjectGroupCode());
		copy.setSync(this.isSync());
		copy.setUserId(this.getUserId());
		copy.setVamcStation(this.getVamcStation());
		copy.setVersion(this.getVersion());
		return copy;
	}
	


	/** Provides toString implementation.
	 * @see java.lang.Object#toString()
	 * @return String representation of this class.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("addressDataQuality: " + this.getAddressDataQuality() + ", ");
		sb.append("dateCreated: " + this.getDateCreated() + ", ");
		sb.append("dateCreatedFromSource: " + this.getDateCreatedFromSource() + ", ");
		sb.append("dateUpdated: " + this.getDateUpdated() + ", ");
		sb.append("dateUpdatedFromSource: " + this.getDateUpdatedFromSource() + ", ");
		sb.append("deleted: " + this.isDeleted() + ", ");
		sb.append("hpScreeningScore: " + this.getHpScreeningScore() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("lastPermanentCity: " + this.getLastPermanentCity() + ", ");
		sb.append("lastPermanentState: " + this.getLastPermanentState() + ", ");
		sb.append("lastPermanentStreet: " + this.getLastPermanentStreet() + ", ");
		sb.append("lastPermanentZip: " + this.getLastPermanentZip() + ", ");
		sb.append("parentId: " + this.getParentId() + ", ");
		sb.append("percentami: " + this.getPercentami() + ", ");
		sb.append("projectGroupCode: " + this.getProjectGroupCode() + ", ");
		sb.append("sync: " + this.isSync() + ", ");
		sb.append("userId: " + this.getUserId() + ", ");
		sb.append("vamcStation: " + this.getVamcStation() + ", ");
		sb.append("version: " + this.getVersion());
		return sb.toString();		
	}


	/** Equals implementation. 
	 * @see java.lang.Object#equals(java.lang.Object)
	 * @param aThat Object to compare with
	 * @return true/false
	 */
	@Override
	public boolean equals(final Object aThat) {
		Object proxyThat = aThat;
		
		if ( this == aThat ) {
			 return true;
		}

		
		if (aThat instanceof HibernateProxy) {
 			// narrow down the proxy to the class we are dealing with.
 			try {
				proxyThat = ((HibernateProxy) aThat).getHibernateLazyInitializer().getImplementation(); 
			} catch (org.hibernate.ObjectNotFoundException e) {
				return false;
		   	}
		}
		if (aThat == null)  {
			 return false;
		}
		
		final Entryssvf that; 
		try {
			that = (Entryssvf) proxyThat;
			if ( !(that.getClassType().equals(this.getClassType()))){
				return false;
			}
		} catch (org.hibernate.ObjectNotFoundException e) {
				return false;
		} catch (ClassCastException e) {
				return false;
		}
		
		
		boolean result = true;
		result = result && (((this.getId() == null) && ( that.getId() == null)) || (this.getId() != null  && this.getId().equals(that.getId())));
		result = result && (((getAddressDataQuality() == null) && (that.getAddressDataQuality() == null)) || (getAddressDataQuality() != null && getAddressDataQuality().equals(that.getAddressDataQuality())));
		result = result && (((getDateCreated() == null) && (that.getDateCreated() == null)) || (getDateCreated() != null && getDateCreated().equals(that.getDateCreated())));
		result = result && (((getDateCreatedFromSource() == null) && (that.getDateCreatedFromSource() == null)) || (getDateCreatedFromSource() != null && getDateCreatedFromSource().equals(that.getDateCreatedFromSource())));
		result = result && (((getDateUpdated() == null) && (that.getDateUpdated() == null)) || (getDateUpdated() != null && getDateUpdated().equals(that.getDateUpdated())));
		result = result && (((getDateUpdatedFromSource() == null) && (that.getDateUpdatedFromSource() == null)) || (getDateUpdatedFromSource() != null && getDateUpdatedFromSource().equals(that.getDateUpdatedFromSource())));
		result = result && (((getEnrollmentid() == null) && (that.getEnrollmentid() == null)) || (getEnrollmentid() != null && getEnrollmentid().getId().equals(that.getEnrollmentid().getId())));	
		result = result && (((getExport() == null) && (that.getExport() == null)) || (getExport() != null && getExport().getId().equals(that.getExport().getId())));	
		result = result && (((getHpScreeningScore() == null) && (that.getHpScreeningScore() == null)) || (getHpScreeningScore() != null && getHpScreeningScore().equals(that.getHpScreeningScore())));
		result = result && (((getLastPermanentCity() == null) && (that.getLastPermanentCity() == null)) || (getLastPermanentCity() != null && getLastPermanentCity().equals(that.getLastPermanentCity())));
		result = result && (((getLastPermanentState() == null) && (that.getLastPermanentState() == null)) || (getLastPermanentState() != null && getLastPermanentState().equals(that.getLastPermanentState())));
		result = result && (((getLastPermanentStreet() == null) && (that.getLastPermanentStreet() == null)) || (getLastPermanentStreet() != null && getLastPermanentStreet().equals(that.getLastPermanentStreet())));
		result = result && (((getLastPermanentZip() == null) && (that.getLastPermanentZip() == null)) || (getLastPermanentZip() != null && getLastPermanentZip().equals(that.getLastPermanentZip())));
		result = result && (((getParentId() == null) && (that.getParentId() == null)) || (getParentId() != null && getParentId().equals(that.getParentId())));
		result = result && (((getPercentami() == null) && (that.getPercentami() == null)) || (getPercentami() != null && getPercentami().equals(that.getPercentami())));
		result = result && (((getProjectGroupCode() == null) && (that.getProjectGroupCode() == null)) || (getProjectGroupCode() != null && getProjectGroupCode().equals(that.getProjectGroupCode())));
		result = result && (((getUserId() == null) && (that.getUserId() == null)) || (getUserId() != null && getUserId().equals(that.getUserId())));
		result = result && (((getVamcStation() == null) && (that.getVamcStation() == null)) || (getVamcStation() != null && getVamcStation().equals(that.getVamcStation())));
		result = result && (((getVersion() == null) && (that.getVersion() == null)) || (getVersion() != null && getVersion().equals(that.getVersion())));
		return result;
	}
}
