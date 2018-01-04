package com.dev.mgm.user.controller;

/**
 * @author ranjit
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.dev.mgm.bean.Device;
import com.dev.mgm.bean.DeviceStatus;
import com.dev.mgm.bean.MessageBean;
import com.dev.mgm.bean.User;
import com.dev.mgm.dao.UserDAO;
import com.dev.mgm.log.DBLog;

/**
 * @author ranjit
 *
 */
public class UserController {
	private static Logger log=LoggerFactory.getLogger(UserController.class);
	
	/**
	 * @param user  object
	 * @return message bean  object which contain status
	 */
	public static  MessageBean registerUser(User u) {
		/*
		 * TODO register the user 
		 * 
		 * 
		 */
		MessageBean m=new MessageBean();
		UserDAO udao=new UserDAO();
		int status=udao.registerUser(u);
		if(status==777) {
			m.setMessage("Success");
			m.setDesc("User register successfully");
		
		}else if(status==-1) {
			m.setMessage("error");
			m.setDesc("User already assign to other");
			
			
		}else if(status==404) {
			m.setMessage("error");
			m.setDesc("Device Not Valid");
			
			
		}else if(status==504) {
			m.setMessage("error");
			m.setDesc("Device used by other already");
			
			
		}
		else {
			m.setMessage("error");
			m.setDesc("device not found");
			
			
		}
			
		
		
		return m;
	}
	
	/**
	 * @param device id
	 * @return message bean  object which contain status
	 */
	
	public static Device checkDeviceStatus(long device_id) {
		/*
		 * TODO know the device status
		 * 
		 * 
		 */
		Device d=new UserDAO().knowDeviceStatus(device_id);
		if(d!=null)
		DBLog.knowLog(d);//maintaing db logs
		return d;
		
	}
	
	/**
	 * @param device id
	 * @return message bean  object which contain statust
	 */
	
	
	public static MessageBean deRegisterUser(long device_id) {
		/*
		 * TODO deregister the device 
		 * 
		 * 
		 */
		UserDAO user=new UserDAO();
		int status=user.deRegisterUser(device_id);     //call deregister dao
		MessageBean m=new MessageBean();
		if(status>-1) {
			if(status==777) {
				m.setMessage("Un-register");
				m.setDesc("device already unregister");	
			//	log.info("Device already unregister","","",device_id,DeviceStatus.UNREGISTER);                   //maintaing db logs
				
			}else if(status==504){
				m.setMessage("error");
				m.setDesc("device not register");	
				
			}else {
				user.deRegisterUser(device_id);
				DBLog.deregisterLog(device_id);	
				log.info("Device Deregister","","",device_id,DeviceStatus.UNREGISTER);                   //maintaing db logs
				m.setMessage("Successfully");
				m.setDesc("Device De registered completed.");
			}
			return m;
		}
			//deregister failed
			m.setMessage("Failed");
			m.setDesc("Device not found");
		return m;
		
	}
	public static Device checkDeviceStatusReg(long device_id) {
		/*
		 * TODO know the device status
		 * 
		 * 
		 */
		Device d=new UserDAO().knowDeviceStatus(device_id);
		
		return d;
		
	}
	
	
	
	
	
}
