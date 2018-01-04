package com.admin.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AdminOTP")
public class AdminOTP {
private int id;
public String getUuid() {
	return uuid;
}
public void setUuid(String uuid) {
	this.uuid = uuid;
}
private int otp;
private String uuid;
@Id
@GeneratedValue
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getOtp() {
	return otp;
}
public void setOtp(int otp) {
	this.otp = otp;
}
}
