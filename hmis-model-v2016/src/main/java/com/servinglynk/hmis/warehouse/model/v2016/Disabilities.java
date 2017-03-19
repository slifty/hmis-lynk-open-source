package com.servinglynk.hmis.warehouse.model.v2016;

import java.io.Serializable;
import java.time.LocalDateTime;
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

import com.servinglynk.hmis.warehouse.enums.DataCollectionStageEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesDisabilitytypeEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesDocumentationonfileEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesIndefiniteandimpairsEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesPathhowconfirmedEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesPathsmiinformationEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesReceivingservicesEnum;


/**
 * Object mapping for hibernate-handled table: disabilities.
 *
 *
 * @author autogenerated
 */

@Entity (name = "disabilities_v2016")
@Table(name = "disabilities", catalog = "hmis", schema = "v2016")
public class Disabilities extends HmisBaseModel implements Cloneable, Serializable {

	/** Serial Version UID. */
	private static final long serialVersionUID = 6492609509614588571L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, java.util.UUID> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, java.util.UUID>());

	/** hashCode temporary storage. */
	private volatile java.util.UUID hashCode;

	private Integer disabilityresponse;
	/** Field mapping. */
	private DisabilitiesDisabilitytypeEnum disabilitytype;
	/** Field mapping. */
	private DisabilitiesDocumentationonfileEnum documentationonfile;
	/** Field mapping. */
	private Enrollment enrollmentid;
	/** Field mapping. */
	private java.util.UUID id;
	/** Field mapping. */
	private DisabilitiesIndefiniteandimpairsEnum indefiniteandimpairs;
	/** Field mapping. */
	private LocalDateTime informationDate;
	/** Field mapping. */
	private DisabilitiesPathhowconfirmedEnum pathhowconfirmed;
	/** Field mapping. */
	private DisabilitiesPathsmiinformationEnum pathsmiinformation;
	/** Field mapping. */
	private DisabilitiesReceivingservicesEnum receivingservices;
	/** Field mapping. */
	private Integer tcellcount;
	/** Field mapping. */
	private Integer tcellcountavailable;
	/** Field mapping. */
	private String tcellcountsource;
	/** Field mapping. */
	private Integer viralLoad;
	/** Field mapping. */
	private Integer viralLoadAvailable;
	/** Field mapping. */
	private String viralLoadSource;
	/** Field mapping. */
	private DataCollectionStageEnum dataCollectionStage;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public Disabilities() {
		// Default constructor
	}

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public Disabilities(java.util.UUID id) {
		this.id = id;
	}

	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Transient
	public Class<?> getClassType() {
		return Disabilities.class;
	}

	 /**
	 * Return the value associated with the column: disabilityresponse.
	 * @return A Integer object (this.disabilityresponse)
	 */
	public Integer getDisabilityresponse() {
		return this.disabilityresponse;

	}

	 /**
	 * Set the value related to the column: disabilityresponse.
	 * @param disabilityresponse the disabilityresponse value you wish to set
	 */
	public void setDisabilityresponse(final Integer disabilityresponse) {
		this.disabilityresponse = disabilityresponse;
	}

	 /**
	 * Return the value associated with the column: disabilitytype.
	 * @return A DisabilitiesDisabilitytypeEnum object (this.disabilitytype)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.DisabilitiesDisabilitytypeEnumType")
	@Basic( optional = true )
	@Column( name = "disabilitytype" )
	public DisabilitiesDisabilitytypeEnum getDisabilitytype() {
		return this.disabilitytype;

	}

	 /**
	 * Set the value related to the column: disabilitytype.
	 * @param disabilitytype the disabilitytype value you wish to set
	 */
	public void setDisabilitytype(final DisabilitiesDisabilitytypeEnum disabilitytype) {
		this.disabilitytype = disabilitytype;
	}


	@Type(type = "com.servinglynk.hmis.warehouse.enums.DataCollectionStageEnumType")
	@Basic( optional = true )
	@Column
	 public DataCollectionStageEnum getDataCollectionStage() {
		return dataCollectionStage;
	}

	public void setDataCollectionStage(DataCollectionStageEnum dataCollectionStage) {
		this.dataCollectionStage = dataCollectionStage;
	}
	 /**
	 * Return the value associated with the column: documentationonfile.
	 * @return A DisabilitiesDocumentationonfileEnum object (this.documentationonfile)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.DisabilitiesDocumentationonfileEnumType")
	@Basic( optional = true )
	@Column
	public DisabilitiesDocumentationonfileEnum getDocumentationonfile() {
		return this.documentationonfile;

	}



	 /**
	 * Set the value related to the column: documentationonfile.
	 * @param documentationonfile the documentationonfile value you wish to set
	 */
	public void setDocumentationonfile(final DisabilitiesDocumentationonfileEnum documentationonfile) {
		this.documentationonfile = documentationonfile;
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
	 * Return the value associated with the column: indefiniteAndImpairsIndependence.
	 * @return A DisabilitiesIndefiniteandimpairsEnum object (this.indefiniteandimpairs)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.DisabilitiesIndefiniteandimpairsEnumType")
	@Basic( optional = true )
	@Column
	 public DisabilitiesIndefiniteandimpairsEnum getIndefiniteandimpairs() {
		return indefiniteandimpairs;
	}

	public void setIndefiniteandimpairs(
			DisabilitiesIndefiniteandimpairsEnum indefiniteandimpairs) {
		this.indefiniteandimpairs = indefiniteandimpairs;
	}

	/**
	 * Return the value associated with the column: informationDate.
	 * @return A LocalDateTime object (this.informationDate)
	 */
	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
	@Basic( optional = true )
	@Column( name = "information_date"  )
	public LocalDateTime getInformationDate() {
		return this.informationDate;

	}



	 /**
	 * Set the value related to the column: informationDate.
	 * @param informationDate the informationDate value you wish to set
	 */
	public void setInformationDate(final LocalDateTime informationDate) {
		this.informationDate = informationDate;
	}


	 /**
	 * Return the value associated with the column: pathhowconfirmed.
	 * @return A DisabilitiesPathhowconfirmedEnum object (this.pathhowconfirmed)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.DisabilitiesPathhowconfirmedEnumType")
	@Basic( optional = true )
	@Column
	public DisabilitiesPathhowconfirmedEnum getPathhowconfirmed() {
		return this.pathhowconfirmed;

	}

	 /**
	 * Set the value related to the column: pathhowconfirmed.
	 * @param pathhowconfirmed the pathhowconfirmed value you wish to set
	 */
	public void setPathhowconfirmed(final DisabilitiesPathhowconfirmedEnum pathhowconfirmed) {
		this.pathhowconfirmed = pathhowconfirmed;
	}

	 /**
	 * Return the value associated with the column: pathsmiinformation.
	 * @return A DisabilitiesPathsmiinformationEnum object (this.pathsmiinformation)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.DisabilitiesPathsmiinformationEnumType")
	@Basic( optional = true )
	@Column
	public DisabilitiesPathsmiinformationEnum getPathsmiinformation() {
		return this.pathsmiinformation;

	}



	 /**
	 * Set the value related to the column: pathsmiinformation.
	 * @param pathsmiinformation the pathsmiinformation value you wish to set
	 */
	public void setPathsmiinformation(final DisabilitiesPathsmiinformationEnum pathsmiinformation) {
		this.pathsmiinformation = pathsmiinformation;
	}


	/**
	 * Return the value associated with the column: receivingservices.
	 * @return A DisabilitiesReceivingservicesEnum object (this.receivingservices)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.DisabilitiesReceivingservicesEnumType")
	@Basic( optional = true )
	@Column
	public DisabilitiesReceivingservicesEnum getReceivingservices() {
		return this.receivingservices;

	}



	 /**
	 * Set the value related to the column: receivingservices.
	 * @param receivingservices the receivingservices value you wish to set
	 */
	public void setReceivingservices(final DisabilitiesReceivingservicesEnum receivingservices) {
		this.receivingservices = receivingservices;
	}


	 /**
	 * Return the value associated with the column: tcellcount.
	 * @return A Integer object (this.tcellcount)
	 */
	public Integer getTcellcount() {
		return this.tcellcount;

	}



	 /**
	 * Set the value related to the column: tcellcount.
	 * @param tcellcount the tcellcount value you wish to set
	 */
	public void setTcellcount(final Integer tcellcount) {
		this.tcellcount = tcellcount;
	}

	 /**
	 * Return the value associated with the column: tcellcountavailable.
	 * @return A Integer object (this.tcellcountavailable)
	 */
	public Integer getTcellcountavailable() {
		return this.tcellcountavailable;

	}



	 /**
	 * Set the value related to the column: tcellcountavailable.
	 * @param tcellcountavailable the tcellcountavailable value you wish to set
	 */
	public void setTcellcountavailable(final Integer tcellcountavailable) {
		this.tcellcountavailable = tcellcountavailable;
	}

	 /**
	 * Return the value associated with the column: tcellcountsource.
	 * @return A String object (this.tcellcountsource)
	 */
	@Basic( optional = true )
	@Column( length = 8  )
	public String getTcellcountsource() {
		return this.tcellcountsource;

	}



	 /**
	 * Set the value related to the column: tcellcountsource.
	 * @param tcellcountsource the tcellcountsource value you wish to set
	 */
	public void setTcellcountsource(final String tcellcountsource) {
		this.tcellcountsource = tcellcountsource;
	}

	 /**
	 * Return the value associated with the column: viralLoad.
	 * @return A Integer object (this.viralLoad)
	 */
	@Basic( optional = true )
	@Column( name = "viral_load"  )
	public Integer getViralLoad() {
		return this.viralLoad;

	}



	 /**
	 * Set the value related to the column: viralLoad.
	 * @param viralLoad the viralLoad value you wish to set
	 */
	public void setViralLoad(final Integer viralLoad) {
		this.viralLoad = viralLoad;
	}

	 /**
	 * Return the value associated with the column: viralLoadAvailable.
	 * @return A Integer object (this.viralLoadAvailable)
	 */
	@Basic( optional = true )
	@Column( name = "viral_load_available"  )
	public Integer getViralLoadAvailable() {
		return this.viralLoadAvailable;

	}



	 /**
	 * Set the value related to the column: viralLoadAvailable.
	 * @param viralLoadAvailable the viralLoadAvailable value you wish to set
	 */
	public void setViralLoadAvailable(final Integer viralLoadAvailable) {
		this.viralLoadAvailable = viralLoadAvailable;
	}

	 /**
	 * Return the value associated with the column: viralLoadSource.
	 * @return A String object (this.viralLoadSource)
	 */
	@Basic( optional = true )
	@Column( name = "viral_load_source", length = 8  )
	public String getViralLoadSource() {
		return this.viralLoadSource;

	}



	 /**
	 * Set the value related to the column: viralLoadSource.
	 * @param viralLoadSource the viralLoadSource value you wish to set
	 */
	public void setViralLoadSource(final String viralLoadSource) {
		this.viralLoadSource = viralLoadSource;
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
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public Disabilities clone() throws CloneNotSupportedException {

        final Disabilities copy = (Disabilities)super.clone();

		copy.setDateCreated(this.getDateCreated());
		copy.setDateCreatedFromSource(this.getDateCreatedFromSource());
		copy.setDateUpdated(this.getDateUpdated());
		copy.setDateUpdatedFromSource(this.getDateUpdatedFromSource());
		copy.setDeleted(this.isDeleted());
		copy.setDisabilityresponse(this.getDisabilityresponse());
		copy.setDisabilitytype(this.getDisabilitytype());
		copy.setDocumentationonfile(this.getDocumentationonfile());
		copy.setEnrollmentid(this.getEnrollmentid());
		copy.setExport(this.getExport());
		copy.setId(this.getId());
		copy.setIndefiniteandimpairs(this.getIndefiniteandimpairs());
		copy.setInformationDate(this.getInformationDate());
		copy.setParentId(this.getParentId());
		copy.setPathhowconfirmed(this.getPathhowconfirmed());
		copy.setPathsmiinformation(this.getPathsmiinformation());
		copy.setProjectGroupCode(this.getProjectGroupCode());
		copy.setReceivingservices(this.getReceivingservices());
		copy.setSync(this.isSync());
		copy.setTcellcount(this.getTcellcount());
		copy.setTcellcountavailable(this.getTcellcountavailable());
		copy.setTcellcountsource(this.getTcellcountsource());
		copy.setUserId(this.getUserId());
		copy.setVersion(this.getVersion());
		copy.setViralLoad(this.getViralLoad());
		copy.setViralLoadAvailable(this.getViralLoadAvailable());
		copy.setViralLoadSource(this.getViralLoadSource());
		return copy;
	}



	/** Provides toString implementation.
	 * @see java.lang.Object#toString()
	 * @return String representation of this class.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();

		sb.append("dateCreated: " + this.getDateCreated() + ", ");
		sb.append("dateCreatedFromSource: " + this.getDateCreatedFromSource() + ", ");
		sb.append("dateUpdated: " + this.getDateUpdated() + ", ");
		sb.append("dateUpdatedFromSource: " + this.getDateUpdatedFromSource() + ", ");
		sb.append("deleted: " + this.isDeleted() + ", ");
		sb.append("disabilityresponse: " + this.getDisabilityresponse() + ", ");
		sb.append("disabilitytype: " + this.getDisabilitytype() + ", ");
		sb.append("documentationonfile: " + this.getDocumentationonfile() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("indefiniteAndImpairsIndependence: " + this.getIndefiniteandimpairs() + ", ");
		sb.append("informationDate: " + this.getInformationDate() + ", ");
		sb.append("parentId: " + this.getParentId() + ", ");
		sb.append("pathhowconfirmed: " + this.getPathhowconfirmed() + ", ");
		sb.append("pathsmiinformation: " + this.getPathsmiinformation() + ", ");
		sb.append("projectGroupCode: " + this.getProjectGroupCode() + ", ");
		sb.append("receivingservices: " + this.getReceivingservices() + ", ");
		sb.append("sync: " + this.isSync() + ", ");
		sb.append("tcellcount: " + this.getTcellcount() + ", ");
		sb.append("tcellcountavailable: " + this.getTcellcountavailable() + ", ");
		sb.append("tcellcountsource: " + this.getTcellcountsource() + ", ");
		sb.append("userId: " + this.getUserId() + ", ");
		sb.append("version: " + this.getVersion() + ", ");
		sb.append("viralLoad: " + this.getViralLoad() + ", ");
		sb.append("viralLoadAvailable: " + this.getViralLoadAvailable() + ", ");
		sb.append("viralLoadSource: " + this.getViralLoadSource());
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

		final Disabilities that;
		try {
			that = (Disabilities) proxyThat;
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
		result = result && (((getDateCreated() == null) && (that.getDateCreated() == null)) || (getDateCreated() != null && getDateCreated().equals(that.getDateCreated())));
		result = result && (((getDateCreatedFromSource() == null) && (that.getDateCreatedFromSource() == null)) || (getDateCreatedFromSource() != null && getDateCreatedFromSource().equals(that.getDateCreatedFromSource())));
		result = result && (((getDateUpdated() == null) && (that.getDateUpdated() == null)) || (getDateUpdated() != null && getDateUpdated().equals(that.getDateUpdated())));
		result = result && (((getDateUpdatedFromSource() == null) && (that.getDateUpdatedFromSource() == null)) || (getDateUpdatedFromSource() != null && getDateUpdatedFromSource().equals(that.getDateUpdatedFromSource())));
		result = result && (((getDisabilityresponse() == null) && (that.getDisabilityresponse() == null)) || (getDisabilityresponse() != null && getDisabilityresponse().equals(that.getDisabilityresponse())));
		result = result && (((getDisabilitytype() == null) && (that.getDisabilitytype() == null)) || (getDisabilitytype() != null && getDisabilitytype().equals(that.getDisabilitytype())));
		result = result && (((getDocumentationonfile() == null) && (that.getDocumentationonfile() == null)) || (getDocumentationonfile() != null && getDocumentationonfile().equals(that.getDocumentationonfile())));
		result = result && (((getEnrollmentid() == null) && (that.getEnrollmentid() == null)) || (getEnrollmentid() != null && getEnrollmentid().getId().equals(that.getEnrollmentid().getId())));
		result = result && (((getExport() == null) && (that.getExport() == null)) || (getExport() != null && getExport().getId().equals(that.getExport().getId())));
		result = result && (((getIndefiniteandimpairs() == null) && (that.getIndefiniteandimpairs() == null)) || (getIndefiniteandimpairs() != null && getIndefiniteandimpairs().equals(that.getIndefiniteandimpairs())));
		result = result && (((getInformationDate() == null) && (that.getInformationDate() == null)) || (getInformationDate() != null && getInformationDate().equals(that.getInformationDate())));
		result = result && (((getParentId() == null) && (that.getParentId() == null)) || (getParentId() != null && getParentId().equals(that.getParentId())));
		result = result && (((getPathhowconfirmed() == null) && (that.getPathhowconfirmed() == null)) || (getPathhowconfirmed() != null && getPathhowconfirmed().equals(that.getPathhowconfirmed())));
		result = result && (((getPathsmiinformation() == null) && (that.getPathsmiinformation() == null)) || (getPathsmiinformation() != null && getPathsmiinformation().equals(that.getPathsmiinformation())));
		result = result && (((getProjectGroupCode() == null) && (that.getProjectGroupCode() == null)) || (getProjectGroupCode() != null && getProjectGroupCode().equals(that.getProjectGroupCode())));
		result = result && (((getReceivingservices() == null) && (that.getReceivingservices() == null)) || (getReceivingservices() != null && getReceivingservices().equals(that.getReceivingservices())));
		result = result && (((getTcellcount() == null) && (that.getTcellcount() == null)) || (getTcellcount() != null && getTcellcount().equals(that.getTcellcount())));
		result = result && (((getTcellcountavailable() == null) && (that.getTcellcountavailable() == null)) || (getTcellcountavailable() != null && getTcellcountavailable().equals(that.getTcellcountavailable())));
		result = result && (((getTcellcountsource() == null) && (that.getTcellcountsource() == null)) || (getTcellcountsource() != null && getTcellcountsource().equals(that.getTcellcountsource())));
		result = result && (((getUserId() == null) && (that.getUserId() == null)) || (getUserId() != null && getUserId().equals(that.getUserId())));
		result = result && (((getVersion() == null) && (that.getVersion() == null)) || (getVersion() != null && getVersion().equals(that.getVersion())));
		result = result && (((getViralLoad() == null) && (that.getViralLoad() == null)) || (getViralLoad() != null && getViralLoad().equals(that.getViralLoad())));
		result = result && (((getViralLoadAvailable() == null) && (that.getViralLoadAvailable() == null)) || (getViralLoadAvailable() != null && getViralLoadAvailable().equals(that.getViralLoadAvailable())));
		result = result && (((getViralLoadSource() == null) && (that.getViralLoadSource() == null)) || (getViralLoadSource() != null && getViralLoadSource().equals(that.getViralLoadSource())));
		return result;
	}
}
