package com.servinglynk.hmis.household.web.rest.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.servinglynk.hmis.household.anntation.ValidateClient;
import com.servinglynk.hmis.warehouse.core.model.JsonDateDeserializer;
import com.servinglynk.hmis.warehouse.core.model.JsonDateTimeSerializer;


/**
 * A DTO for the HouseholdMembership entity.
 */
@ValidateClient(clientIdField="globalClientId",linkField="link")
public class HouseholdMembershipDTO implements Serializable {

    private UUID householdMembershipId;

    @NotNull(message="Global client is required.")
    private UUID globalClientId;
    
	@JsonDeserialize(using=JsonDateDeserializer.class)
	@JsonSerialize(using=JsonDateTimeSerializer.class)
    private LocalDateTime dateCreated;
	
	@JsonDeserialize(using=JsonDateDeserializer.class)
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	private LocalDateTime dateUpdated;

    private String relationshipToHeadOfHousehold;

    private UUID globalHouseholdId;
    
    private UUID userId;
    
    @JsonProperty(access=Access.WRITE_ONLY)
    private String link;
    
    
    
    
    public UUID getHouseholdMembershipId() {
		return householdMembershipId;
	}

	public void setHouseholdMembershipId(UUID householdMembershipId) {
		this.householdMembershipId = householdMembershipId;
	}

	public UUID getGlobalClientId() {
        return globalClientId;
    }

    public void setGlobalClientId(UUID globalClientId) {
        this.globalClientId = globalClientId;
    }
    public String getRelationshipToHeadOfHousehold() {
        return relationshipToHeadOfHousehold;
    }

    public void setRelationshipToHeadOfHousehold(String relationshipToHeadOfHousehold) {
        this.relationshipToHeadOfHousehold = relationshipToHeadOfHousehold;
    }

    

	public UUID getGlobalHouseholdId() {
		return globalHouseholdId;
	}

	public void setGlobalHouseholdId(UUID globalHouseholdId) {
		this.globalHouseholdId = globalHouseholdId;
	}

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public LocalDateTime getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(LocalDateTime dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        HouseholdMembershipDTO householdMembershipDTO = (HouseholdMembershipDTO) o;

        if ( ! Objects.equals(householdMembershipId, householdMembershipDTO.householdMembershipId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(householdMembershipId);
    }

    @Override
    public String toString() {
        return "HouseholdMembershipDTO{" +
            "householdMembershipId=" + householdMembershipId +
            ", globalClientId='" + globalClientId + "'" +
            ", relationshipToHeadOfHousehold='" + relationshipToHeadOfHousehold + "'" +
            '}';
    }
}
