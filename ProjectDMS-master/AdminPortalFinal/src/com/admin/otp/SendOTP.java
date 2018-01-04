package com.admin.otp;

public class SendOTP {
	
	public boolean sendMessage(String mobile_no,int otp) {
		
		new AccountVerficationSMS(mobile_no,otp);
		
		return true;
	}
	
	
	
	
	
	public int getOTP() {
		int otp= 100000 + (int)(Math.random() * 999999); 
		return otp;
		
	}
}
