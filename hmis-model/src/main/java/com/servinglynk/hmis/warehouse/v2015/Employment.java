package com.servinglynk.hmis.warehouse.v2015;

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

import com.servinglynk.hmis.warehouse.enums.EmploymentEmployedEnum;
import com.servinglynk.hmis.warehouse.enums.EmploymentEmploymentTypeEnum;
import com.servinglynk.hmis.warehouse.enums.EmploymentNotEmployedReasonEnum;


/** 
 * Object mapping for hibernate-handled table: employment.
 * 
 *
 * @author autogenerated
 */
@Entity (name = "employment_v2015")
@Table(name = "employment", catalog = "hmis", schema = "v2015")
public class Employment extends HmisBaseModelV2015 implements Cloneable, Serializable {

	/** Serial Version UID. */
	private static final long serialVersionUID = -6654649692481756031L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities 
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, java.util.UUID> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, java.util.UUID>());
	
	/** hashCode temporary storage. */
	private volatile java.util.UUID hashCode;
	
	private EmploymentEmployedEnum employed;
	/** Field mapping. */
	private EmploymentEmploymentTypeEnum employmentType;
	/** Field mapping. */
	private Enrollment enrollmentid;
	/** Field mapping. */
	private java.util.UUID id;
	/** Field mapping. */
	private LocalDateTime informationDate;
	/** Field mapping. */
	private EmploymentNotEmployedReasonEnum notEmployedReason;
	/** Field mapping. */
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public Employment() {
		// Default constructor
	} 

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public Employment(java.util.UUID id) {
		this.id = id;
	}
	
 


 
	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Transient
	public Class<?> getClassType() {
		return Employment.class;
	}
 
	 /**
	 * Return the value associated with the column: employed.
	 * @return A EmploymentEmployedEnum object (this.employed)
	 */
//	@Type(type = "enumType", parameters = {@Parameter(name = "enum", value = "com.servinglynk.hmis.enums.db.hmis.EmploymentEmployedEnum"), @Parameter(name = "forPgSQL", value = "true")})
	@Type(type = "com.servinglynk.hmis.warehouse.enums.EmploymentEmployedEnum")
	@Basic( optional = true )
	@Column( name = "employed" )
	public EmploymentEmployedEnum getEmployed() {
		return this.employed;
		
	}
	

  
	 /**  
	 * Set the value related to the column: employed.
	 * @param employed the employed value you wish to set
	 */
	public void setEmployed(final EmploymentEmployedEnum employed) {
		this.employed = employed;
	}

	 /**
	 * Return the value associated with the column: employmentType.
	 * @return A EmploymentEmploymentTypeEnum object (this.employmentType)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.EmploymentEmployedEnum")
	@Basic( optional = true )
	@Column( name = "employment_type" )
	public EmploymentEmploymentTypeEnum getEmploymentType() {
		return this.employmentType;
		
	}
	

  
	 /**  
	 * Set the value related to the column: employmentType.
	 * @param employmentType the employmentType value you wish to set
	 */
	public void setEmploymentType(final EmploymentEmploymentTypeEnum employmentType) {
		this.employmentType = employmentType;
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
	 * Return the value associated with the column: notEmployedReason.
	 * @return A EmploymentNotEmployedReasonEnum object (this.notEmployedReason)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.EmploymentEmployedEnum")
	@Basic( optional = true )
	@Column( name = "not_employed_reason" )
	public EmploymentNotEmployedReasonEnum getNotEmployedReason() {
		return this.notEmployedReason;
		
	}
	

  
	 /**  
	 * Set the value related to the column: notEmployedReason.
	 * @param notEmployedReason the notEmployedReason value you wish to set
	 */
	public void setNotEmployedReason(final EmploymentNotEmployedReasonEnum notEmployedReason) {
		this.notEmployedReason = notEmployedReason;
	}

   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public Employment clone() throws CloneNotSupportedException {
		
        final Employment copy = (Employment)super.clone();

		copy.setDateCreated(this.getDateCreated());
		copy.setDateCreatedFromSource(this.getDateCreatedFromSource());
		copy.setDateUpdated(this.getDateUpdated());
		copy.setDateUpdatedFromSource(this.getDateUpdatedFromSource());
		copy.setDeleted(this.isDeleted());
		copy.setEmployed(this.getEmployed());
		copy.setEmploymentType(this.getEmploymentType());
		copy.setEnrollmentid(this.getEnrollmentid());
		copy.setExport(this.getExport());
		copy.setId(this.getId());
		copy.setInformationDate(this.getInformationDate());
		copy.setNotEmployedReason(this.getNotEmployedReason());
		copy.setParentId(this.getParentId());
		copy.setProjectGroupCode(this.getProjectGroupCode());
		copy.setSync(this.isSync());
		copy.setUserId(this.getUserId());
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
		
		sb.append("dateCreated: " + this.getDateCreated() + ", ");
		sb.append("dateCreatedFromSource: " + this.getDateCreatedFromSource() + ", ");
		sb.append("dateUpdated: " + this.getDateUpdated() + ", ");
		sb.append("dateUpdatedFromSource: " + this.getDateUpdatedFromSource() + ", ");
		sb.append("deleted: " + this.isDeleted() + ", ");
		sb.append("employed: " + this.getEmployed() + ", ");
		sb.append("employmentType: " + this.getEmploymentType() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("informationDate: " + this.getInformationDate() + ", ");
		sb.append("notEmployedReason: " + this.getNotEmployedReason() + ", ");
		sb.append("parentId: " + this.getParentId() + ", ");
		sb.append("projectGroupCode: " + this.getProjectGroupCode() + ", ");
		sb.append("sync: " + this.isSync() + ", ");
		sb.append("userId: " + this.getUserId() + ", ");
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
		
		final Employment that; 
		try {
			that = (Employment) proxyThat;
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
		result = result && (((getEmployed() == null) && (that.getEmployed() == null)) || (getEmployed() != null && getEmployed().equals(that.getEmployed())));
		result = result && (((getEmploymentType() == null) && (that.getEmploymentType() == null)) || (getEmploymentType() != null && getEmploymentType().equals(that.getEmploymentType())));
		result = result && (((getEnrollmentid() == null) && (that.getEnrollmentid() == null)) || (getEnrollmentid() != null && getEnrollmentid().getId().equals(that.getEnrollmentid().getId())));	
		result = result && (((getExport() == null) && (that.getExport() == null)) || (getExport() != null && getExport().getId().equals(that.getExport().getId())));	
		result = result && (((getInformationDate() == null) && (that.getInformationDate() == null)) || (getInformationDate() != null && getInformationDate().equals(that.getInformationDate())));
		result = result && (((getNotEmployedReason() == null) && (that.getNotEmployedReason() == null)) || (getNotEmployedReason() != null && getNotEmployedReason().equals(that.getNotEmployedReason())));
		result = result && (((getParentId() == null) && (that.getParentId() == null)) || (getParentId() != null && getParentId().equals(that.getParentId())));
		result = result && (((getProjectGroupCode() == null) && (that.getProjectGroupCode() == null)) || (getProjectGroupCode() != null && getProjectGroupCode().equals(that.getProjectGroupCode())));
		result = result && (((getUserId() == null) && (that.getUserId() == null)) || (getUserId() != null && getUserId().equals(that.getUserId())));
		result = result && (((getVersion() == null) && (that.getVersion() == null)) || (getVersion() != null && getVersion().equals(that.getVersion())));
		return result;
	}
}