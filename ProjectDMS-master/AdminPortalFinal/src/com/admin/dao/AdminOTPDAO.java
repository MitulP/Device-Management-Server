package com.admin.dao;


import java.util.UUID;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.admin.bean.Admin;
import com.admin.bean.AdminOTP;
import com.admin.otp.SendOTP;
import com.dev.mgm.db.MySessionFactory;

public class AdminOTPDAO {
	private static Logger log=Logger.getLogger(AdminOTPDAO.class);
	private static Session session=null;
	public static boolean generateOTP() {
	try {
		
		SessionFactory sf=MySessionFactory.getSessionFactory();
		session =sf.openSession();
		AdminOTP admin_otp=session.get(AdminOTP.class,1);
		Admin admin=session.get(Admin.class,1);
		Transaction tx=session.beginTransaction();
		SendOTP sendotp=new SendOTP();
		
		int otp=sendotp.getOTP();
		sendotp.sendMessage(admin.getMobileno(),otp);
		
		if(admin_otp!=null) {
			
			admin_otp.setOtp(otp);
			admin_otp.setUuid(UUID.randomUUID().toString());
			session.update(admin_otp);
			
		}else {
			admin_otp=new AdminOTP();
			admin_otp.setId(1);
			admin_otp.setOtp(otp);
			admin_otp.setUuid(UUID.randomUUID().toString());
			session.save(admin_otp);
		}
		
		tx.commit();
		log.info("OTP send sucessfully");
	
	
	}catch(HibernateException e) {
		log.error("Admin otp error",e);
		
	}finally {
		
		session.close();
		
	}
	
	
	
	
	return false;
	
	}public String verifyUserOTP(int otp) {
		 Session session;
		try {
			
			SessionFactory sf=MySessionFactory.getSessionFactory();
			session=sf.openSession();
			AdminOTP adminotp=session.get(AdminOTP.class, 1);
			if(adminotp.getOtp()==otp){
				log.info("OTP verifyed");
				return adminotp.getUuid();
			}
			log.info("OTP not matched");
		}catch(HibernateException e) {
			log.error("verify OTP exception",e);
		}
		
		
		return null;
		
	}
}
