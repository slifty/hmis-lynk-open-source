package com.servinglynk.hmis.warehouse.common;

import java.util.UUID;

public class GeneralUtil {

	public static String getNewGuid() {
	public static String getUniqueToken(int length) {
		StringBuffer buffer = new StringBuffer();
		while(buffer.length() < length) {
			buffer.append(getNewGuid().replace("-", ""));
		}
		return buffer.substring(0, length);
	}
}