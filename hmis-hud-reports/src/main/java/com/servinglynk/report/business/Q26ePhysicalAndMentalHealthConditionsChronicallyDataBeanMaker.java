package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q26ePhysicalAndMentalHealthConditionsChronicallyDataBean;

public class Q26ePhysicalAndMentalHealthConditionsChronicallyDataBeanMaker {
	
	public static List<Q26ePhysicalAndMentalHealthConditionsChronicallyDataBean> getQ26ePhysicalAndMentalHealthConditionsChronicallyList(){
		
		Q26ePhysicalAndMentalHealthConditionsChronicallyDataBean q26ePhysicalAndMentalHealthConditionsChronicallyTable = new Q26ePhysicalAndMentalHealthConditionsChronicallyDataBean();
	
		q26ePhysicalAndMentalHealthConditionsChronicallyTable.setq26eMentalIllnessAtEntry(BigInteger.valueOf(0));
		q26ePhysicalAndMentalHealthConditionsChronicallyTable.setq26eMentalIllnessStayers(BigInteger.valueOf(0));
		q26ePhysicalAndMentalHealthConditionsChronicallyTable.setq26eMentalIllnessLeavers(BigInteger.valueOf(0));

		q26ePhysicalAndMentalHealthConditionsChronicallyTable.setq26eAlcoholAbuseAtEntry(BigInteger.valueOf(0));
		q26ePhysicalAndMentalHealthConditionsChronicallyTable.setq26eAlcoholAbuseStayers(BigInteger.valueOf(0));
		q26ePhysicalAndMentalHealthConditionsChronicallyTable.setq26eAlcoholAbuseLeavers(BigInteger.valueOf(0));

		q26ePhysicalAndMentalHealthConditionsChronicallyTable.setq26eDrugAbuseAtEntry(BigInteger.valueOf(0));
		q26ePhysicalAndMentalHealthConditionsChronicallyTable.setq26eDrugAbuseStayers(BigInteger.valueOf(0));
		q26ePhysicalAndMentalHealthConditionsChronicallyTable.setq26eDrugAbuseLeavers(BigInteger.valueOf(0));

		q26ePhysicalAndMentalHealthConditionsChronicallyTable.setq26eBothAlcoholAndDrugAbuseAtEntry(BigInteger.valueOf(0));
		q26ePhysicalAndMentalHealthConditionsChronicallyTable.setq26eBothAlcoholAndDrugAbuseStayers(BigInteger.valueOf(0));
		q26ePhysicalAndMentalHealthConditionsChronicallyTable.setq26eBothAlcoholAndDrugAbuseLeavers(BigInteger.valueOf(0));

		q26ePhysicalAndMentalHealthConditionsChronicallyTable.setq26eChronicHealthConditionAtEntry(BigInteger.valueOf(0));
		q26ePhysicalAndMentalHealthConditionsChronicallyTable.setq26eChronicHealthConditionStayers(BigInteger.valueOf(0));
		q26ePhysicalAndMentalHealthConditionsChronicallyTable.setq26eChronicHealthConditionLeavers(BigInteger.valueOf(0));

		q26ePhysicalAndMentalHealthConditionsChronicallyTable.setq26eHIVAIDSAndRelatedDiseasesAtEntry(BigInteger.valueOf(0));
		q26ePhysicalAndMentalHealthConditionsChronicallyTable.setq26eHIVAIDSAndRelatedDiseasesStayers(BigInteger.valueOf(0));
		q26ePhysicalAndMentalHealthConditionsChronicallyTable.setq26eHIVAIDSAndRelatedDiseasesLeavers(BigInteger.valueOf(0));

		q26ePhysicalAndMentalHealthConditionsChronicallyTable.setq26eDevelopmentalDisabilityAtEntry(BigInteger.valueOf(0));
		q26ePhysicalAndMentalHealthConditionsChronicallyTable.setq26eDevelopmentalDisabilityStayers(BigInteger.valueOf(0));
		q26ePhysicalAndMentalHealthConditionsChronicallyTable.setq26eDevelopmentalDisabilityLeavers(BigInteger.valueOf(0));

		q26ePhysicalAndMentalHealthConditionsChronicallyTable.setq26ePhysicalDisabilityAtEntry(BigInteger.valueOf(0));
		q26ePhysicalAndMentalHealthConditionsChronicallyTable.setq26ePhysicalDisabilityStayers(BigInteger.valueOf(0));
		q26ePhysicalAndMentalHealthConditionsChronicallyTable.setq26ePhysicalDisabilityLeavers(BigInteger.valueOf(0));
		
		return Arrays.asList(q26ePhysicalAndMentalHealthConditionsChronicallyTable);
	}

}
