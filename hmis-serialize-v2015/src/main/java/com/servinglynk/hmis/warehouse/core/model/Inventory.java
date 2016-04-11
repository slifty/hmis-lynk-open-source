package com.servinglynk.hmis.warehouse.core.model; 

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("inventory")
public class Inventory extends ClientModel{


      private UUID inventoryId;

      private Integer availabilty;

      private UUID bedinventory;

      private Integer bedtype;

      private Integer hmisparticipatingbeds;

      private Integer householdtype;

      private LocalDateTime inventoryenddate;

      private LocalDateTime inventorystartdate;

      private Integer unitinventory;



      public UUID getInventoryId(){
          return inventoryId;
      }
      public void setInventoryId(UUID inventoryId){
          this.inventoryId = inventoryId;
      }
      public Integer getAvailabilty(){
          return availabilty;
      }
      public void setAvailabilty(Integer availabilty){
          this.availabilty = availabilty;
      }
      public UUID getBedinventory(){
          return bedinventory;
      }
      public void setBedinventory(UUID bedinventory){
          this.bedinventory = bedinventory;
      }
      public Integer getBedtype(){
          return bedtype;
      }
      public void setBedtype(Integer bedtype){
          this.bedtype = bedtype;
      }
      public Integer getHmisparticipatingbeds(){
          return hmisparticipatingbeds;
      }
      public void setHmisparticipatingbeds(Integer hmisparticipatingbeds){
          this.hmisparticipatingbeds = hmisparticipatingbeds;
      }
      public Integer getHouseholdtype(){
          return householdtype;
      }
      public void setHouseholdtype(Integer householdtype){
          this.householdtype = householdtype;
      }
      public LocalDateTime getInventoryenddate(){
          return inventoryenddate;
      }
      public void setInventoryenddate(LocalDateTime inventoryenddate){
          this.inventoryenddate = inventoryenddate;
      }
      public LocalDateTime getInventorystartdate(){
          return inventorystartdate;
      }
      public void setInventorystartdate(LocalDateTime inventorystartdate){
          this.inventorystartdate = inventorystartdate;
      }
      public Integer getUnitinventory(){
          return unitinventory;
      }
      public void setUnitinventory(Integer unitinventory){
          this.unitinventory = unitinventory;
      }

 }