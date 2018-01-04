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
public class User {
	
	
private long user_id;
private String name;
private long device_id;

public long getDevice_id() {
	return device_id;
}
public void setDevice_id(long device_id) {
	this.device_id = device_id;
}
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


}
