package com.dev.mgm.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dev.mgm.bean.Device;
import com.dev.mgm.bean.DeviceStatus;
import com.dev.mgm.bean.User;


public class DBLog {
	private static Logger log=LoggerFactory.getLogger(DBLog.class);
		public static boolean saveRegLog(User u,Device d) {
			
			log.info("User Register Successfully",u.getUser_id(),u.getName(),u.getDevice_id(),d.getStatus());
		return true;
		
		}public static boolean knowLog(Device d) {
			log.info("Device Status ","","",d.getDevice_id(),d.getStatus());
			return true;
		}public static boolean deregisterLog(long d) {
			
			log.info("Device Deregister","","",d,DeviceStatus.UNREGISTER);
			return true;
		}
}
