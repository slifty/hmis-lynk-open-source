package com.servinglynk.hmis.household.service;

import com.servinglynk.hmis.household.domain.HouseholdMembership;
import com.servinglynk.hmis.household.repository.HouseholdMembershipRepository;
import com.servinglynk.hmis.household.web.rest.dto.HouseholdMembershipDTO;
import com.servinglynk.hmis.household.web.rest.mapper.HouseholdMembershipMapper;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing HouseholdMembership.
 */
@Service
@Transactional
public class HouseholdMembershipService {

    private final Logger log = LoggerFactory.getLogger(HouseholdMembershipService.class);
    
    @Inject
    private HouseholdMembershipRepository householdMembershipRepository;
    
    @Inject
    private HouseholdMembershipMapper householdMembershipMapper;
    
    @Autowired
    HibernateTemplate hibernateTemplate;
    
    /**
     * Save a householdMembership.
     * 
     * @param householdMembershipDTO the entity to save
     * @return the persisted entity
     */
    @Transactional
    public List<HouseholdMembershipDTO> save(UUID householdId,List<HouseholdMembershipDTO> householdMembershipDTOs) {
        log.debug("Request to save HouseholdMembership : {}", householdMembershipDTOs);
        List<HouseholdMembershipDTO> lhouseholdmembersDTOs=new ArrayList<HouseholdMembershipDTO>(); 
        for(HouseholdMembershipDTO dto: householdMembershipDTOs){
        	dto.setDateCreated(LocalDateTime.now());
        	dto.setDateUpdated(LocalDateTime.now());
        	dto.setGlobalHouseholdId(householdId);
        	dto.setInactive(false);
        	dto.setHouseholdMembershipId(UUID.randomUUID());
        	lhouseholdmembersDTOs.add(dto);
        }
        List<HouseholdMembership> householdMembers = householdMembershipMapper.householdMembershipDTOsToHouseholdMemberships(lhouseholdmembersDTOs);
        householdMembers = householdMembershipRepository.save(householdMembers);
    //    List<HouseholdMembershipDTO> result = householdMembershipMapper.householdMembershipsToHouseholdMembershipDTOs(householdMembers);
        return lhouseholdmembersDTOs;
    }
    
    @Transactional
    public HouseholdMembershipDTO update(UUID householdId, HouseholdMembershipDTO householdMembershipDTO) {
        log.debug("Request to save HouseholdMembership : {}", householdMembershipDTO);
        householdMembershipDTO.setDateUpdated(LocalDateTime.now());
        householdMembershipDTO.setGlobalHouseholdId(householdId);
        HouseholdMembership householdMember = householdMembershipMapper.householdMembershipDTOToHouseholdMembership(householdMembershipDTO);
        householdMember = householdMembershipRepository.save(householdMember);
      //  HouseholdMembershipDTO result = householdMembershipMapper.householdMembershipToHouseholdMembershipDTO(householdMember);
        return householdMembershipDTO;
    }

    /**
     *  Get all the householdMemberships.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Transactional(readOnly = true) 
    public List<HouseholdMembership> getAllHouseholdMembersByHouseholdId(UUID householdId, Pageable pageable) {
        log.debug("Request to get all HouseholdMemberships");
        DetachedCriteria crit=DetachedCriteria.forClass(HouseholdMembership.class);
        crit.add(Restrictions.eq("globalHousehold.globalHouseholdId",householdId ));
        List<HouseholdMembership> members=new ArrayList<HouseholdMembership>();
        members=(List<HouseholdMembership>)hibernateTemplate.findByCriteria(crit);
        //Page<HouseholdMembership> result = householdMembershipRepository.findAll(pageable); 
        return members;
    }
    
    @Transactional(readOnly = true) 
    public Page<HouseholdMembership> findAll(Pageable pageable) {
        log.debug("Request to get all HouseholdMemberships");
        Page<HouseholdMembership> result = householdMembershipRepository.findAll(pageable); 
        return result;
    }

    /**
     *  Get one householdMembership by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true) 
    public HouseholdMembershipDTO findOne(UUID id) {
        log.debug("Request to get HouseholdMembership : {}", id);
        HouseholdMembership householdMembership = householdMembershipRepository.findOne(id);
        HouseholdMembershipDTO householdMembershipDTO = householdMembershipMapper.householdMembershipToHouseholdMembershipDTO(householdMembership);
        return householdMembershipDTO;
    }

    /**
     *  Delete the  householdMembership by id.
     *  
     *  @param id the id of the entity
     */
    public void delete(UUID id) {
        log.debug("Request to delete HouseholdMembership : {}", id);
        HouseholdMembership householdMembership=householdMembershipRepository.findOne(id);
        householdMembershipRepository.delete(householdMembership);
    }
}
