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

import org.hibernate.annotations.Type;
import org.hibernate.proxy.HibernateProxy;

import com.servinglynk.hmis.warehouse.enums.SitePrincipalSiteEnum;
import com.servinglynk.hmis.warehouse.enums.StateEnum;


/**
 * Object mapping for hibernate-handled table: site.
 *
 *
 * @author autogenerated
 */
@Entity(name = "site_stagv2015")
@Table(name = "site", catalog = "hmis", schema = "stagv2015")
public class Site extends HmisBaseStagingModel implements Cloneable, Serializable {

	/** Serial Version UID. */
	private static final long serialVersionUID = -6352811751941522574L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, java.util.UUID> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, java.util.UUID>());

	/** hashCode temporary storage. */
	private volatile java.util.UUID hashCode;


	/** Field mapping. */
	private String address;
	/** Field mapping. */
	private String city;
	/** Field mapping. */
	private Coc coc;
	/** Field mapping. */
	private Integer geocode;
	/** Field mapping. */
	private java.util.UUID id;
	/** Field mapping. */
	private SitePrincipalSiteEnum principalSite;
	/** Field mapping. */
	private StateEnum state;
	/** Field mapping. */
	private String zip;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public Site() {
		// Default constructor
	}

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public Site(java.util.UUID id) {
		this.id = id;
	}





	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Transient
	public Class<?> getClassType() {
		return Site.class;
	}


	 /**
	 * Return the value associated with the column: address.
	 * @return A String object (this.address)
	 */
	@Basic( optional = true )
	@Column( length = 100  )
	public String getAddress() {
		return this.address;

	}



	 /**
	 * Set the value related to the column: address.
	 * @param address the address value you wish to set
	 */
	public void setAddress(final String address) {
		this.address = address;
	}

	 /**
	 * Return the value associated with the column: city.
	 * @return A String object (this.city)
	 */
	@Basic( optional = true )
	@Column( length = 50  )
	public String getCity() {
		return this.city;

	}



	 /**
	 * Set the value related to the column: city.
	 * @param city the city value you wish to set
	 */
	public void setCity(final String city) {
		this.city = city;
	}

	 /**
	 * Return the value associated with the column: coc.
	 * @return A Coc object (this.coc)
	 */
	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = true )
	@JoinColumn(name = "coc_id", nullable = true )
	public Coc getCoc() {
		return this.coc;

	}



	 /**
	 * Set the value related to the column: coc.
	 * @param coc the coc value you wish to set
	 */
	public void setCoc(final Coc coc) {
		this.coc = coc;
	}

	 /**
	 * Return the value associated with the column: geocode.
	 * @return A Integer object (this.geocode)
	 */
	public Integer getGeocode() {
		return this.geocode;

	}



	 /**
	 * Set the value related to the column: geocode.
	 * @param geocode the geocode value you wish to set
	 */
	public void setGeocode(final Integer geocode) {
		this.geocode = geocode;
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
		 * Return the value associated with the column: principalSite.
		 * @return A SitePrincipalSiteEnum object (this.principalSite)
		 */
		@Type(type = "com.servinglynk.hmis.warehouse.enums.SitePrincipalSiteEnumType")
		@Basic( optional = true )
		@Column( name = "principal_site"  )
		public SitePrincipalSiteEnum getPrincipalSite() {
			return this.principalSite;

		}



	 /**
	 * Set the value related to the column: principalSite.
	 * @param principalSite the principalSite value you wish to set
	 */
	public void setPrincipalSite(final SitePrincipalSiteEnum principalSite) {
		this.principalSite = principalSite;
	}

	 /**
	 * Return the value associated with the column: zip.
	 * @return A String object (this.zip)
	 */
	@Basic( optional = true )
	@Column( length = 2147483647  )
	public String getZip() {
		return this.zip;

	}



	 /**
	 * Set the value related to the column: zip.
	 * @param zip the zip value you wish to set
	 */
	public void setZip(final String zip) {
		this.zip = zip;
	}
	/**
	 * Return the value associated with the column: addressDataQuality.
	 * @return A StateEnum object (this.addressDataQuality)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.StateEnumType")
	@Basic( optional = true )
	@Column( name = "state"  )
	public StateEnum getState() {
		return this.state;

	}



	 /**
	 * Set the value related to the column: addressDataQuality.
	 * @param addressDataQuality the addressDataQuality value you wish to set
	 */
	public void setState(final StateEnum state) {
		this.state = state;
	}

   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public Site clone() throws CloneNotSupportedException {

        final Site copy = (Site)super.clone();

		copy.setAddress(this.getAddress());
		copy.setCity(this.getCity());
		copy.setCoc(this.getCoc());
		copy.setDateCreated(this.getDateCreated());
		copy.setDateCreatedFromSource(this.getDateCreatedFromSource());
		copy.setDateUpdated(this.getDateUpdated());
		copy.setDateUpdatedFromSource(this.getDateUpdatedFromSource());
		copy.setDeleted(this.isDeleted());
		copy.setExport(this.getExport());
		copy.setGeocode(this.getGeocode());
		copy.setId(this.getId());
		copy.setParentId(this.getParentId());
		copy.setPrincipalSite(this.getPrincipalSite());
		copy.setProjectGroupCode(this.getProjectGroupCode());
		copy.setState(this.getState());
		copy.setSync(this.isSync());
		copy.setUserId(this.getUserId());
		copy.setVersion(this.getVersion());
		copy.setZip(this.getZip());
		return copy;
	}



	/** Provides toString implementation.
	 * @see java.lang.Object#toString()
	 * @return String representation of this class.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();

		sb.append("address: " + this.getAddress() + ", ");
		sb.append("city: " + this.getCity() + ", ");
		sb.append("dateCreated: " + this.getDateCreated() + ", ");
		sb.append("dateCreatedFromSource: " + this.getDateCreatedFromSource() + ", ");
		sb.append("dateUpdated: " + this.getDateUpdated() + ", ");
		sb.append("dateUpdatedFromSource: " + this.getDateUpdatedFromSource() + ", ");
		sb.append("deleted: " + this.isDeleted() + ", ");
		sb.append("geocode: " + this.getGeocode() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("parentId: " + this.getParentId() + ", ");
		sb.append("principalSite: " + this.getPrincipalSite() + ", ");
		sb.append("projectGroupCode: " + this.getProjectGroupCode() + ", ");
		sb.append("state: " + this.getState() + ", ");
		sb.append("sync: " + this.isSync() + ", ");
		sb.append("userId: " + this.getUserId() + ", ");
		sb.append("version: " + this.getVersion() + ", ");
		sb.append("zip: " + this.getZip());
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

		final Site that;
		try {
			that = (Site) proxyThat;
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
		result = result && (((getAddress() == null) && (that.getAddress() == null)) || (getAddress() != null && getAddress().equals(that.getAddress())));
		result = result && (((getCity() == null) && (that.getCity() == null)) || (getCity() != null && getCity().equals(that.getCity())));
		result = result && (((getCoc() == null) && (that.getCoc() == null)) || (getCoc() != null && getCoc().getId().equals(that.getCoc().getId())));
		result = result && (((getDateCreated() == null) && (that.getDateCreated() == null)) || (getDateCreated() != null && getDateCreated().equals(that.getDateCreated())));
		result = result && (((getDateCreatedFromSource() == null) && (that.getDateCreatedFromSource() == null)) || (getDateCreatedFromSource() != null && getDateCreatedFromSource().equals(that.getDateCreatedFromSource())));
		result = result && (((getDateUpdated() == null) && (that.getDateUpdated() == null)) || (getDateUpdated() != null && getDateUpdated().equals(that.getDateUpdated())));
		result = result && (((getDateUpdatedFromSource() == null) && (that.getDateUpdatedFromSource() == null)) || (getDateUpdatedFromSource() != null && getDateUpdatedFromSource().equals(that.getDateUpdatedFromSource())));
		result = result && (((getExport() == null) && (that.getExport() == null)) || (getExport() != null && getExport().getId().equals(that.getExport().getId())));
		result = result && (((getGeocode() == null) && (that.getGeocode() == null)) || (getGeocode() != null && getGeocode().equals(that.getGeocode())));
		result = result && (((getParentId() == null) && (that.getParentId() == null)) || (getParentId() != null && getParentId().equals(that.getParentId())));
		result = result && (((getPrincipalSite() == null) && (that.getPrincipalSite() == null)) || (getPrincipalSite() != null && getPrincipalSite().equals(that.getPrincipalSite())));
		result = result && (((getProjectGroupCode() == null) && (that.getProjectGroupCode() == null)) || (getProjectGroupCode() != null && getProjectGroupCode().equals(that.getProjectGroupCode())));
		result = result && (((getState() == null) && (that.getState() == null)) || (getState() != null && getState().equals(that.getState())));
		result = result && (((getUserId() == null) && (that.getUserId() == null)) || (getUserId() != null && getUserId().equals(that.getUserId())));
		result = result && (((getVersion() == null) && (that.getVersion() == null)) || (getVersion() != null && getVersion().equals(that.getVersion())));
		result = result && (((getZip() == null) && (that.getZip() == null)) || (getZip() != null && getZip().equals(that.getZip())));
		return result;
	}

}
