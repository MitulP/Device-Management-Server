package com.dev.mgm.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="USER")
public class UserBack {
	
	
private long user_id;
private String name;
private Device handleDev;

@Id
@GeneratedValue
public long getUser_id() {
	return user_id;
}
public void setUser_id(long user_id) {
	this.user_id = user_id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="device_id")
public Device getHandleDev() {
	return handleDev;
}
public void setHandleDev(Device handleDev) {
	this.handleDev = handleDev;
}

}
