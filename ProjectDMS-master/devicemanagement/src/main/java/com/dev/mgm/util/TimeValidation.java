package com.dev.mgm.util;



public class TimeValidation {
	/*
	 * @param timestamp1,timestamp2
	 * @return dev
	 * 
	 */
	public static boolean compareValidDate(java.sql.Timestamp date1,java.sql.Timestamp date2) {
		//TODO compare to Timestamp
		int i= date1.compareTo(date2);
		if(i<0) 
			return true;
		else
			
			return false;
			
		
	
	}
}
