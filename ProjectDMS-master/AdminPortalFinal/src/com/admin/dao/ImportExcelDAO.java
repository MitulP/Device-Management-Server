package com.admin.dao;

import java.io.InputStream;
import java.util.List;
import java.util.ListIterator;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.admin.bean.Device;
import com.dev.mgm.db.MySessionFactory;

public class ImportExcelDAO {
private static Logger log=Logger.getLogger(ImportExcelDAO.class);
public static boolean importFile(InputStream in) {
	
	
		if(in==null) {
			log.info("File Stream is Empty");
			return false;
		}
		log.info("File Stream is found");
		List<Device> device=LoadExcel.importFile(in); 
		
		Session session=null;
		try {
			
			SessionFactory sf=MySessionFactory.getSessionFactory();
			session=sf.openSession();
			if(device.size()!=0) {
			log.info("prepare to store device"+device.size());
			Device d;
			ListIterator<Device> listdevice=device.listIterator();
				while(listdevice.hasNext()) {
					
					
					d=listdevice.next();
					if(!checkDeviceAlreadyAvailablity(d)) {
						
						Transaction tx=session.beginTransaction();
						session.save(d);
						tx.commit();
						
					}else {
						
						log.info("device is already register");
					}
					
				}
			}
			
			
			
			
		}catch(HibernateException e) {
			
			log.info("Hibernate  file Exception");
			
			
		}catch(Exception e) {
			log.info("Import file Exception");
				return false;
		}
		finally {
			session.close();
			device=null;
		}
		
		

		return true;
	}
/*
 * @param Device object
 *	@return device is avaliable or not status
 */
	public static boolean checkDeviceAlreadyAvailablity(Device d) {
		Session session=null;
		try {
			SessionFactory sf=MySessionFactory.getSessionFactory();
			session=sf.openSession();
			Device de=session.get(Device.class, d.getDevice_id());
			if(de!=null)
				return true;
			else
				return false;
			
			
			
		}catch(HibernateException e) {
			log.error("Excel Device check exception",e);
			
		}
		
		
		return false;
	}
}

