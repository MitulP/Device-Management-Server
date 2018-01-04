package com.admin.dao;



import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;


import com.admin.bean.Admin;
import com.dev.mgm.db.MySessionFactory;

public class AdminLogin {
	private static Logger log=Logger.getLogger(AdminLogin.class);
	public static boolean checkLogin(Admin a) {
		log.info("admin login check");
		try {
			SessionFactory sf=MySessionFactory.getSessionFactory();
			Session session=sf.openSession();
			Criteria cr=session.createCriteria(Admin.class);
			
			cr.add(Restrictions.eq("uname", a.getUname()));
			cr.add(Restrictions.eq("password", a.getPassword()));
			log.info(a.getUname()+"------"+a.getPassword());
			
			
			Admin admin=(Admin) cr.uniqueResult();
			if(admin!=null) {
				log.info("Login Sucessfully");
				return true;
			}else {
				log.info("Login failed");
				
				
			}
			
			
			
		}catch(HibernateException e) {
			log.error("Admin Login check error" ,e);
			
		}
		
		
		return false;
	} 
}
