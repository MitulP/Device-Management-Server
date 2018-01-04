package com.dev.mgm.dao;

import java.util.List;
import java.util.ListIterator;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.jboss.logging.DelegatingBasicLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dev.mgm.bean.Device;
import com.dev.mgm.bean.DeviceStatus;
import com.dev.mgm.bean.User;
import com.dev.mgm.db.MySessionFactory;
import com.dev.mgm.log.DBLog;
import com.dev.mgm.util.TimeValidation;

/**
 * @author ranjit
 *
 */
/**
 * @author ranjit
 *
 */

public class UserDAO {
	
	
	private static Logger log=LoggerFactory.getLogger(UserDAO.class);
	private long key;
	/**
	 * @param User object
	 * @return user object
	 */
	public int  registerUser(User u) {
		SessionFactory sf=MySessionFactory.getSessionFactory();
		Session session=sf.openSession();
		int status=checkDeviceAvablity(u.getDevice_id());     //check device avablity
		
		try {
						
			if(status==777) {
				
				
				Device d=session.get(Device.class,u.getDevice_id());
				if(checkValidity(d)) {
					changeStatus(d);
					session.close();
					return 404;             //not valid
				}if(isDeviceUsed(d.getDevice_id())) {
					session.close();
					return 504;            // device used by other
				} 
				
				
				else {
				
					Transaction tx=session.beginTransaction();
					d.setStatus(DeviceStatus.REGISTER);
					session.update(d);
					tx.commit();
					tx=session.beginTransaction();
					session.save(u);
					tx.commit();
					DBLog.saveRegLog(u, d);
				
				}
			}
			
			
			
			
		}catch(HibernateException e) {
			
			log.error("Register Exception",e);
			
		}finally {
			
			session.close();
		}
		return status;

		
		
	}
	
	/**
	 * @param Device id
	 * @return device availability of devices
	 */
	public int checkDeviceAvablity(long device_id) {
		/*
		 *TODO check the device is available or not based on device id 
		 *     
		 *
		 */
		try {
			log.info("check device");
			SessionFactory sf=MySessionFactory.getSessionFactory();
			Session session=sf.openSession();
			Device d=session.get(Device.class, device_id);
			
			
			if(d!=null) {  							
					//device found
					if(d.getStatus()==DeviceStatus.NEW||d.getStatus()==DeviceStatus.UNREGISTER) {
						//device status are new or unregister
						session.close();
						return 777;
					}else if(d.getStatus()==DeviceStatus.NOT_VALID) {
						session.close();
						return 404;
					}
					session.close();
					//device already used by other user
					return -1;
				}else { 
				//device not found
				session.close();
				return 0;
				}
			
		}catch(HibernateException e) {
			
		log.error("check device avalible exception ",e);
		}
		
		
		//device not found
		
		return 0;
		
		
	}
	
	/**
	 * @param Device id
	 * @return device object
	 */
	public Device knowDeviceStatus(long device_id) {
	/*
	 * TODO check the device status 
	 * 
	 */		try {
			SessionFactory sf=MySessionFactory.getSessionFactory();
			Session session=sf.openSession();
			Device d=session.get(Device.class, device_id);
			session.close();
			if(d!=null) {                   		//check device is available or not             
					if(checkValidity(d)) { 
						d=changeStatus(d);        //update validate _till date
						log.info("Device Not Valid right now");	
					}
				
				log.info("Deivce status found");  
				session.close();
				return d;						//return device status
				
			}else {
				 log.info("Deivce status not found ID"+device_id);          //device not found
				 d=new Device(device_id,null,DeviceStatus.NOT_FOUND);
				 session.close();
				 return d;
			}
		}catch(HibernateException e) {
			
		log.error("check device avablity exception ",e);
		}
		return null;
	}
	/**
	 * @param Device id
	 * @return remove device status 
	 */
	public int deRegisterUser(long device_id) {
		/*
		 * TODO check the device status 
		 * 
		 */

		try {
			SessionFactory sf=MySessionFactory.getSessionFactory();
			Session session=sf.openSession();
			Device d=session.get(Device.class, device_id);
			Transaction tx=session.beginTransaction();
			if(!checkDeviceAssign(device_id)) {
				return 504;
			}else {
			
			if(d!=null) {
				log.info("Deivce found");
				if(d.getStatus()==DeviceStatus.UNREGISTER) {
					session.close();
					return 777; //device already unregister
				}/*else if(d.getStatus()!=DeviceStatus.REGISTER) {
					return 504; //device not register
				}*/
				d.setStatus(DeviceStatus.UNREGISTER);
				session.save(d);
				tx.commit();
				deleteUser(d.getDevice_id());      //delete user
				session.close();
				
				return 0;      //device deregister successfully
				
			}else {
				log.info("Deivce  not found ID"+device_id);
				session.close();
				return -1;  //device not found
			}
				}
		}catch(HibernateException e) {
			
		log.error("device deregister error ",e);
		}
		
		return -1;      //device not found
		
	}
	/**
	 * @param Device object
	 * @return check validity of devices
	 */
	public boolean checkValidity(Device d) {
		
		log.info("Checking Validity");
		return TimeValidation.compareValidDate(new java.sql.Timestamp(d.getValid_till().getTime()),new java.sql.Timestamp(new java.util.Date().getTime()));
		
	}
	
	/**
	 * @param Device object
	 * @return change device object
	 */
	public Device changeStatus(Device d) {
		try {
		SessionFactory sf=MySessionFactory.getSessionFactory();
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		d=session.get(Device.class, d.getDevice_id());
		d.setStatus(DeviceStatus.NOT_VALID);
		log.info("change status excecuting");
		session.update(d);           //update device status
		tx.commit();
		session.close();
		}catch(HibernateException e) {
		
		log.error("device change Status error ",e);
		
		}
		return d;
		
		
	}
	
	/**
	 * @param device id
	 * @return message bean  object which contain statust
	 */
	
	
	public boolean checkDeviceAssign(long device_id) {
		/*
		 * TODO check the device status 
		 * 
		 */

		try {
			SessionFactory sf=MySessionFactory.getSessionFactory();
			Session session=sf.openSession();
			Criteria cr=session.createCriteria(User.class);
			cr.add(Restrictions.eqOrIsNull("device_id", device_id));
			User d=(User) cr.uniqueResult();
			session.close();
			if(d!=null) {
				return true;  //device is assign to another user
			}
			
			return false;    //device is not assign;
			
		}catch(HibernateException e) {
			
			log.error("checkDeviceAssign  error ",e);
		}
		
		
		return false;
	}
	
	/**
	 * @param device id
	 * @return message bean  object which contain statust
	 */
	
	public static boolean deleteUser(long device_id) {
		/*
		 * TODO check the device status 
		 * 
		 */

		try {
			SessionFactory sf=MySessionFactory.getSessionFactory();
			Session session=sf.openSession();
			Criteria cr=session.createCriteria(User.class);
			cr.add(Restrictions.eq("device_id", device_id));
			User u=(User) cr.uniqueResult();                           //deregister user
			if(u!=null) {
				log.info("user deleted successfully");
				Transaction tx=session.beginTransaction();
				session.delete(u);
				tx.commit();
				session.close();
				return true;
			}
			session.close();
		}catch(HibernateException e) {
			
			log.error("checkDeviceAssign  error ",e);                     
		}
		
		
		log.info("user not found");
		return false;	
	}
	
	
	/**
	 * @param Device id
	 * @return device object
	 *//*
	public int checkstatus(long device_id) {
	
	 * TODO check the device status 
	 * 
	 		try {
			SessionFactory sf=MySessionFactory.getSessionFactory();
			Session session=sf.openSession();
			Device d=session.get(Device.class, device_id);
			if(d!=null) {                   		//check device is available or not             
					if(checkValidity(d)) { 
						d=changeStatus(d);        //update validate _till date
						log.info("Device Not Valid right now");	
						return 2;                //device not valid
					}
				
				log.info("Deivce status found");  
				return 1;						//return device status
				
			}else {
				 log.info("Deivce status not found ID"+device_id);          //device not found
				 d=new Device(device_id,null,DeviceStatus.NOT_FOUND);
				return 0;
			}
		}catch(HibernateException e) {
			
		log.error("check device avablity exception ",e);
		}
		return -777;                     //error
	}
	
	*/
	
	public boolean isDeviceUsed(long device_id) {
		SessionFactory sf=MySessionFactory.getSessionFactory();
		Session session=sf.openSession();
		Criteria cr=session.createCriteria(User.class);
		cr.add(Restrictions.eq("device_id", device_id));
		User u=(User) cr.uniqueResult(); 
		try {
			if(u!=null)
				return true;
			
		session.close();	
		}catch(HibernateException e) {
			
			session.close();
		}
		return false;
	}
	
}
