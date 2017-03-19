package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q25aNumberOfVeteransDataBean;

public class Q25aNumberOfVeteransDataBeanMaker {
	
	public static List<Q25aNumberOfVeteransDataBean> getQ25aNumberOfVeteransList(){
		
		Q25aNumberOfVeteransDataBean q25aNumberOfVeteransTable = new Q25aNumberOfVeteransDataBean();
		
				q25aNumberOfVeteransTable.setQ25aChronicallyHomelessVeteranTotal(BigInteger.valueOf(0));
				q25aNumberOfVeteransTable.setQ25aChronicallyHomelessVeteranWithoutChildren(BigInteger.valueOf(0));
				q25aNumberOfVeteransTable.setQ25aChronicallyHomelessVeteranWithChildAndAdults(BigInteger.valueOf(0));
				q25aNumberOfVeteransTable.setQ25aChronicallyHomelessVeteranUnknownHouseHold(BigInteger.valueOf(0));

				q25aNumberOfVeteransTable.setQ25aNonChronicallyHomelessVeteranTotal(BigInteger.valueOf(0));
				q25aNumberOfVeteransTable.setQ25aNonChronicallyHomelessVeteranWithoutChildren(BigInteger.valueOf(0));
				q25aNumberOfVeteransTable.setQ25aNonChronicallyHomelessVeteranWithChildAndAdults(BigInteger.valueOf(0));
				q25aNumberOfVeteransTable.setQ25aNonChronicallyHomelessVeteranUnknownHouseHold(BigInteger.valueOf(0));

				q25aNumberOfVeteransTable.setQ25aNotVeteranTotal(BigInteger.valueOf(0));
				q25aNumberOfVeteransTable.setQ25aNotVeteranWithoutChildren(BigInteger.valueOf(0));
				q25aNumberOfVeteransTable.setQ25aNotVeteranWithChildAndAdults(BigInteger.valueOf(0));
				q25aNumberOfVeteransTable.setQ25aNotVeteranUnknownHouseHold(BigInteger.valueOf(0));

				q25aNumberOfVeteransTable.setQ25aClientRefusedTotal(BigInteger.valueOf(0));
				q25aNumberOfVeteransTable.setQ25aClientRefusedWithoutChildren(BigInteger.valueOf(0));
				q25aNumberOfVeteransTable.setQ25aClientRefusedWithChildAndAdults(BigInteger.valueOf(0));
				q25aNumberOfVeteransTable.setQ25aClientRefusedUnknownHouseHold(BigInteger.valueOf(0));

				q25aNumberOfVeteransTable.setQ25aDataNotCollectedTotal(BigInteger.valueOf(0));
				q25aNumberOfVeteransTable.setQ25aDataNotCollectedWithoutChildren(BigInteger.valueOf(0));
				q25aNumberOfVeteransTable.setQ25aDataNotCollectedWithChildAndAdults(BigInteger.valueOf(0));
				q25aNumberOfVeteransTable.setQ25aDataNotCollectedUnknownHouseHold(BigInteger.valueOf(0));

				q25aNumberOfVeteransTable.setQ25aTotTotal(BigInteger.valueOf(0));
				q25aNumberOfVeteransTable.setQ25aTotWithoutChildren(BigInteger.valueOf(0));
				q25aNumberOfVeteransTable.setQ25aTotWithChildAndAdults(BigInteger.valueOf(0));
				q25aNumberOfVeteransTable.setQ25aTotUnknownHouseHold(BigInteger.valueOf(0));

		
		return Arrays.asList(q25aNumberOfVeteransTable);
	}

}
