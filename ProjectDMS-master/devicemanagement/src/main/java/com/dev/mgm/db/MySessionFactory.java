package com.dev.mgm.db;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MySessionFactory {
	private static SessionFactory session;
	private static Logger log=LoggerFactory.getLogger(MySessionFactory.class);
	static{
	
		try {
			Configuration cfg=new Configuration();       //loading hibernate env
			cfg.configure("hibernate.cfg.xml");         //loading hibernate config with entity class
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
					applySettings(cfg.getProperties());
			
			log.info("Hibernate Configuration file loaded Successfully");
			session = cfg.buildSessionFactory(builder.build());
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
