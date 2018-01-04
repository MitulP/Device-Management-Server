package com.dev.mgm.bean;

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.TimeZone;

public class MasterDeviceJSON {
private long id,device_id;
private String username;
private DeviceStatus status;
private String valid_till;

private java.sql.Timestamp timestamp;
public String getValid_till() {
	Date date=new Date(timestamp.getTime());
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a"); 
   sdf.setTimeZone(TimeZone.getTimeZone("GMT+1"));
   String formattedDate = sdf.format(date);
    return formattedDate;
	
	
}
public void setValid_till(String valid_till) {
	this.valid_till = valid_till;
}
public MasterDeviceJSON(User u,Device d) {
	this.id=u.getUser_id();
	this.device_id=d.getDevice_id();
	this.username=u.getName();
	this.status=d.getStatus();
	this.timestamp=(Timestamp) d.getValid_till();
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public long getDevice_id() {
	return device_id;
}
public void setDevice_id(long device_id) {
	this.device_id = device_id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public DeviceStatus getStatus() {
	return status;
}
public void setStatus(DeviceStatus status) {
	this.status = status;
}

}
