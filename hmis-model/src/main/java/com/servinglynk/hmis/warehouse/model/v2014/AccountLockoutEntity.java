package com.servinglynk.hmis.warehouse.model.v2014;import java.util.Date;import java.util.UUID;import javax.persistence.Column;import javax.persistence.Entity;import javax.persistence.FetchType;import javax.persistence.GeneratedValue;import javax.persistence.JoinColumn;import javax.persistence.OneToOne;import javax.persistence.Table;import org.hibernate.annotations.GenericGenerator;@SuppressWarnings("serial")@Entity@Table(name = "hmis_account_lockout")public class AccountLockoutEntity extends BaseModel {    @javax.persistence.Id    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")    @GeneratedValue(generator = "uuid-gen")    @org.hibernate.annotations.Type(type="pg-uuid")	@Column(name = "id")	private UUID id;			@Column(name = "last_attempt_status")	private Integer lastLoginStatus;	@Column(name = "last_attempt_at")	private Date lastAttemptAt;		@Column(name="failure_attempt_count")	private Integer failureCount;		public UUID getId() {		return id;	}	protected void setId(UUID id) {		this.id = id;	}	 public Integer getLastLoginStatus() {		return lastLoginStatus;	}	public void setLastLoginStatus(Integer lastLoginStatus) {		this.lastLoginStatus = lastLoginStatus;	}	public Date getLastAttemptAt() {		return lastAttemptAt;	}	public void setLastAttemptAt(Date lastAttemptAt) {		this.lastAttemptAt = lastAttemptAt;	}	public Integer getFailureCount() {		return failureCount;	}	public void setFailureCount(Integer failureCount) {		this.failureCount = failureCount;	}	@OneToOne(fetch = FetchType.LAZY, optional=false)	@JoinColumn(name = "user_id", nullable=false, referencedColumnName="id")	private HmisUser account;	public HmisUser getAccount() {		return this.account;	} 	public void setAccount(HmisUser account) {		this.account = account;	}	}