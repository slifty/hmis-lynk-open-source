package com.servinglynk.hmis.household.web.rest.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.servinglynk.hmis.household.domain.GlobalHousehold;
import com.servinglynk.hmis.household.domain.HouseholdMembership;
import com.servinglynk.hmis.household.web.rest.dto.GlobalHouseholdDTO;

@Component("globalHouseholdMapper")
public class GlobalHouseholdMapperImpl implements GlobalHouseholdMapper {

	@Override
	public GlobalHouseholdDTO globalHouseholdToGlobalHouseholdDTO(GlobalHousehold globalHousehold) {
			GlobalHouseholdDTO globalHouseholdDTO = new GlobalHouseholdDTO();
			globalHouseholdDTO.setDateCreated(globalHousehold.getDateCreated());
			globalHouseholdDTO.setDateUpdated(globalHousehold.getDateUpdated());
			globalHouseholdDTO.setGlobalHouseholdId(globalHousehold.getGlobalHouseholdId());
			globalHouseholdDTO.setHeadOfHouseholdId(globalHousehold.getHeadOfHouseholdId());
			globalHouseholdDTO.setUserId(globalHousehold.getUserId());
			globalHouseholdDTO.setLink(globalHousehold.getHeadOfHouseHoldLink());
		return globalHouseholdDTO;
	}

	@Override
	public List<GlobalHouseholdDTO> globalHouseholdsToGlobalHouseholdDTOs(List<GlobalHousehold> globalHouseholds) {
				List<GlobalHouseholdDTO> globalHouseholdDTOs = new ArrayList<GlobalHouseholdDTO>();
				for(GlobalHousehold globalHousehold : globalHouseholds){
					globalHouseholdDTOs.add(this.globalHouseholdToGlobalHouseholdDTO(globalHousehold));
				}
		return globalHouseholdDTOs;
	}

	@Override
	public GlobalHousehold globalHouseholdDTOToGlobalHousehold(GlobalHouseholdDTO globalHouseholdDTO) {
		GlobalHousehold globalHousehold = new GlobalHousehold();
		globalHousehold.setGlobalHouseholdId(globalHouseholdDTO.getGlobalHouseholdId());
		globalHousehold.setHeadOfHouseholdId(globalHouseholdDTO.getHeadOfHouseholdId());	
		globalHousehold.setHeadOfHouseHoldLink(globalHouseholdDTO.getLink());
		
		if(globalHouseholdDTO.getGlobalHouseholdId()==null){
			HouseholdMembership membership = new HouseholdMembership();
			membership.setGlobalClientId(globalHouseholdDTO.getHeadOfHouseholdId());
			membership.setGlobalHousehold(globalHousehold);
			membership.setClientLink(globalHouseholdDTO.getLink());
			globalHousehold.getMembers().add(membership);
		}
	return globalHousehold;
	}

	@Override
	public List<GlobalHousehold> globalHouseholdDTOsToGlobalHouseholds(List<GlobalHouseholdDTO> globalHouseholdDTOs) {
		List<GlobalHousehold> globalHouseholds = new ArrayList<GlobalHousehold>();
			for(GlobalHouseholdDTO globalHouseholdDTO : globalHouseholdDTOs){
				globalHouseholds.add(this.globalHouseholdDTOToGlobalHousehold(globalHouseholdDTO));
			}
		
		return globalHouseholds;
	}

}
