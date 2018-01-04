package com.admin.otp;

	
import org.apache.log4j.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.admin.bean.Admin;
import com.dev.mgm.db.MySessionFactory;

public class ChangePassword {
	private static Logger log=Logger.getLogger(ChangePassword.class);
	public static boolean changePassword(String pass,String cpass) {
		Session session=null;
		try {
			SessionFactory sf=MySessionFactory.getSessionFactory();
			session =sf.openSession();
			Admin admin=session.get(Admin.class,1);
			Transaction tx=session.beginTransaction();
			if(admin!=null) {
				admin.setPassword(pass);
				admin.setNewPassword(cpass);
				session.save(admin);
				tx.commit();
				log.info("password sucessfully chanaged");
				return true;
				
			}
			log.info("password not chanaged");
			
			
			
			
		}catch(HibernateException e) {
			log.error("ChangePassword error",e);
			
		}
		
		
		
		
		
		
		
		
		return false;
	}
}
