package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q26bNumberOfChronicallyHomelessPersonsByHouseholdDataBean;
import com.servinglynk.report.bean.ReportData;

public class Q26bNumberOfChronicallyHomelessPersonsByHouseholdDataBeanMaker {
	
public static List<Q26bNumberOfChronicallyHomelessPersonsByHouseholdDataBean> getQ26bNumberOfChronicallyHomelessPersonsByHouseholdList(ReportData data){
		
	Q26bNumberOfChronicallyHomelessPersonsByHouseholdDataBean q26bNumberOfChronicallyHomelessPersonsByHouseholdTable = new Q26bNumberOfChronicallyHomelessPersonsByHouseholdDataBean();
		
		q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bChronicallyHomelessTotal(data.getNoOfChronicallyHomelessPersons());
		q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bChronicallyHomelessWithoutChild(BigInteger.valueOf(0));
		q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bChronicallyHomelessWithChildAndAdults(BigInteger.valueOf(0));
		q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bChronicallyHomelessWithOnlyChild(BigInteger.valueOf(0));
		q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bChronicallyHomelessUnknownHouseholdType(BigInteger.valueOf(0));

		q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bNotChronicallyHomelessTotal(BigInteger.valueOf(0));
		q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bNotChronicallyHomelessWithoutChild(BigInteger.valueOf(0));
		q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bNotChronicallyHomelessWithChildAndAdults(BigInteger.valueOf(0));
		q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bNotChronicallyHomelessWithOnlyChild(BigInteger.valueOf(0));
		q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bNotChronicallyHomelessUnknownHouseholdType(BigInteger.valueOf(0));

		q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bClientRefusedTotal(BigInteger.valueOf(0));
		q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bClientRefusedWithoutChild(BigInteger.valueOf(0));
		q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bClientRefusedWithChildAndAdults(BigInteger.valueOf(0));
		q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bClientRefusedWithOnlyChild(BigInteger.valueOf(0));
		q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bClientRefusedUnknownHouseholdType(BigInteger.valueOf(0));

		q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bDataNotCollectedTotal(BigInteger.valueOf(0));
		q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bDataNotCollectedWithoutChild(BigInteger.valueOf(0));
		q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bDataNotCollectedWithChildAndAdults(BigInteger.valueOf(0));
		q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bDataNotCollectedWithOnlyChild(BigInteger.valueOf(0));
		q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bDataNotCollectedUnknownHouseholdType(BigInteger.valueOf(0));

		q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bTotTotal(BigInteger.valueOf(0));
		q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bTotWithoutChild(BigInteger.valueOf(0));
		q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bTotWithChildAndAdults(BigInteger.valueOf(0));
		q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bTotWithOnlyChild(BigInteger.valueOf(0));
		q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bTotUnknownHouseholdType(BigInteger.valueOf(0));
		
		return Arrays.asList(q26bNumberOfChronicallyHomelessPersonsByHouseholdTable); 
		
	}


}
