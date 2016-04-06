package com.servinglynk.hmis.warehouse.core.model; 

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonRootName("funder")
public class Funder extends ClientModel{

    private UUID funderId;

    @JsonSerialize(using=JsonDateSerializer.class)
    @JsonDeserialize(using=JsonDateDeserializer.class)
    private LocalDateTime enddate;

    private Integer funder;

    private String grantid;
    
    @JsonSerialize(using=JsonDateSerializer.class)
    @JsonDeserialize(using=JsonDateDeserializer.class)
    private LocalDateTime startdate;



    public UUID getFunderId(){
        return funderId;
    }
    public void setFunderId(UUID funderId){
        this.funderId = funderId;
    }
    public LocalDateTime getEnddate(){
        return enddate;
    }
    public void setEnddate(LocalDateTime enddate){
        this.enddate = enddate;
    }
    public Integer getFunder(){
        return funder;
    }
    public void setFunder(Integer funder){
        this.funder = funder;
    }
    public String getGrantid(){
        return grantid;
    }
    public void setGrantid(String grantid){
        this.grantid = grantid;
    }
    public LocalDateTime getStartdate(){
        return startdate;
    }
    public void setStartdate(LocalDateTime startdate){
        this.startdate = startdate;
    }
 }
