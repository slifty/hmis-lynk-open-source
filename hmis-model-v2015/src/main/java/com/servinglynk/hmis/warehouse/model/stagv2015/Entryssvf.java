package com.servinglynk.hmis.warehouse.model.stagv2015;

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

import org.hibernate.proxy.HibernateProxy;


/**
 * Object mapping for hibernate-handled table: entryssvf.
 *
 *
 * @author autogenerated
 */


@Entity (name = "entryssvf_stagv2015")
@Table(name = "entryssvf", catalog = "hmis", schema = "stagv2015")
public class Entryssvf extends HmisBaseStagingModel implements Cloneable, Serializable {

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
	/** Field mapping. */
	private Integer percentami;
	/** Field mapping. */
	/** Field mapping. */
	private String vamcStation;
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
	public Integer getPercentami() {
		return this.percentami;

	}



	 /**
	 * Set the value related to the column: percentami.
	 * @param percentami the percentami value you wish to set
	 */
	public void setPercentami(final Integer percentami) {
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