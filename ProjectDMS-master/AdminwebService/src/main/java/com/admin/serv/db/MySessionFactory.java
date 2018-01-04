package com.admin.serv.db;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MySessionFactory {
	private static SessionFactory session;
	private static Logger log=LoggerFactory.getLogger(MySessionFactory.class);
	static{
	
		try {
			Configuration cfg=new Configuration();
			cfg.configure("hibernate.cfg2.xml");
			log.info("Hibernate Configuration file loaded Successfully");
			session=cfg.buildSessionFactory();
			log.info("Session factory object created");
	
			}catch(HibernateException hiber) {
			
			log.error("session factory creation error ",hiber);
		}
	}
	public static SessionFactory getSessionFactory() {
		
		log.info("session factory call");
		return session;
		
	}
}
