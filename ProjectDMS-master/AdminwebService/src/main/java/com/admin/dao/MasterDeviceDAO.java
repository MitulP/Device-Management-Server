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
import com.dev.mgm.bean.Device;
import com.dev.mgm.bean.LoggingEvent;
import com.dev.mgm.bean.MasterDeviceJSON;
import com.dev.mgm.bean.User;

/**
 *@author ranjit
 *@date 12/12/2017
 */
public class MasterDeviceDAO {
	private static Logger log=Logger.getLogger(MasterDeviceDAO.class);
	
	/*
	 * @Param page_number,pagesize
	 * @return list of all devices
	 * 
	 */
	public List<MasterDeviceJSON> getAllDevice(int page_number,int pagesize){
		
		//TODO load all master device list
		Session session=null;
		ListIterator<Device> listdevice=null;
		ListIterator<User> user=null;
		
		List<MasterDeviceJSON>  masterjson=new ArrayList<MasterDeviceJSON>();
	try {
		
			SessionFactory sf=MySessionFactory.getSessionFactory();
			session=sf.openSession();
			Criteria cr=session.createCriteria(Device.class);
			
			cr.setFirstResult((page_number - 1) * pagesize);
			cr.setMaxResults(pagesize);
			//cr.addOrder(Order.desc("device_id"));
			List<Device>device=cr.list();
			if(device.size()!=0) {
				 listdevice=device.listIterator();
				//searching user which associated with device
				 	
				 log.info("Device is loading");
				 while(listdevice.hasNext()) {
					//searching user 
					 Device d=listdevice.next();
					Criteria cruser=session.createCriteria(User.class);
					cruser.add(Restrictions.eq("device_id",d.getDevice_id()));    //check device id
					
					User u=(User) cruser.uniqueResult();
					if(u==null) {
						u=new User();
						u.setUser_id(0);
						u.setName("DEVICE NOT ASSIGN");
						log.info("Device not assign to user");
					}
					
					masterjson.add(new MasterDeviceJSON(u, d));
					
					
					
					
				}
				
				
			}
				
			
			
			
	}catch(HibernateException e) {
		
		
		log.error("hibernate error",e);
	}finally {
		listdevice=null;
		user=null;
		session.close();
	}	

		return masterjson;
	}
}
