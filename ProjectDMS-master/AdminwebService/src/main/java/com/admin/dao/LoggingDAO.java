package com.admin.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.admin.serv.db.MySessionFactory;
import com.dev.mgm.bean.LoggingEvent;
import com.dev.mgm.bean.LoggingEventJSON;

/**
 * @author ranjit
 *
 */

public class LoggingDAO {
	private static Logger log=Logger.getLogger(LoggingDAO.class);
	
	//temp method
	public LoggingEventJSON getLogUser() {
		try {
			
			SessionFactory sf=MySessionFactory.getSessionFactory();
			Session session=sf.openSession();
			LoggingEvent log=session.get(LoggingEvent.class,6l);
			if(log!=null) {
			return new LoggingEventJSON(log);
			}
		}catch(HibernateException e) {e.printStackTrace();
		}
		
		return null;
	}
	/*
	 * @param pagenumber and pageindex for pagination
	 * @return  list of logging event
	 * 
	 */
	public List<LoggingEventJSON> getAllLogs(int page_number,int pagesize){
		//TODO  Load all logs of device
		try {
			
			SessionFactory sf=MySessionFactory.getSessionFactory();
			Session session=sf.openSession();
			Criteria cr=session.createCriteria(LoggingEvent.class);
			
					cr.setFirstResult((page_number - 1) * pagesize);
					cr.setMaxResults(pagesize);
				List<LoggingEvent> event=cr.list();
				if(event!=null) {
				List<LoggingEventJSON> logjson=new ArrayList<LoggingEventJSON>();
				ListIterator<LoggingEvent> event_iter=event.listIterator();
				log.info("Logging Event log loaded");
				while(event_iter.hasNext()) {
					
					logjson.add(new LoggingEventJSON((LoggingEvent)event_iter.next()));
					
				}
				log.info("Logging Event Converted to JSON Format ");
				return logjson;
				}else {
					log.info("logging event not found");
					List<LoggingEventJSON> logjson=new ArrayList<LoggingEventJSON>();
					return logjson;
					
					
				}
		}catch(HibernateException e) {
			log.error("Hibernate Error in Loggin DAO "+e);
			
		}
		
		
		return null;
	}
}
