package com.admin.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.admin.serv.db.MySessionFactory;
import com.dev.mgm.bean.LoggingEvent;
import com.dev.mgm.bean.LoggingEventJSON;

/**
 * @author ranjit
 * 
 */
public class FilterLoggingDAO {
	
	private static Logger log=Logger.getLogger(FilterLoggingDAO.class);
	private static Session session;
	private static List<LoggingEventJSON> logjson=new ArrayList<LoggingEventJSON>();
	/*
	 * @Param logging status, username,  pagination page number and number of record per page
	 * @Return list of filter logs
	 * 
	 */
	public static List<LoggingEventJSON> getFilterLogs(String status,String username,int page_number,int pagesize){
		//TODO filter logs based on critera
		
		
		
		logjson.clear();  //clear the all previous record in list 
		
		
		try {
			SessionFactory sf=MySessionFactory.getSessionFactory();
			 session=sf.openSession();
			Criteria cr=session.createCriteria(LoggingEvent.class);
			
		
			if(!status.equalsIgnoreCase("ALL")) {                   //apply status filter
				log.info("appled filter on status");
				cr.add(Restrictions.like("arg3",""+status+""));
			}
			if(!username.equalsIgnoreCase("search")) {            //apply username filter
				log.info("appled filter on username");
				cr.add(Restrictions.like("arg1","%"+username+"%"));
			}
			
			
			cr.addOrder(Order.desc("event_id"));
			cr.setFirstResult((page_number - 1) * pagesize);              //pagination
			cr.setMaxResults(pagesize);
			List<LoggingEvent> event=cr.list();
			ListIterator<LoggingEvent> event_iter=event.listIterator();
			log.info("Logging Event log loaded");
			while(event_iter.hasNext()) {
				
				logjson.add(new LoggingEventJSON((LoggingEvent)event_iter.next()));    //converting into json template class format
				
			}
			log.info("return filter logs");
			
		}catch(HibernateException e) {
			
			log.error("filter logs hibernate exception ");
		}finally {
			
			session.close();
			
		}
		
		
		
		
		
		
		
		
		
		return logjson;
		
		
		
		
		
	}
	
	
}
