package com.dev.mgm.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;





@Entity
@Table(name="DEVICE")
public class Device {

private long device_id;

private Date valid_till;

private  DeviceStatus status;


public Device() {}

public Device(long device_id,Date valid_till,DeviceStatus status) {
	this.device_id=device_id;
	this.valid_till=valid_till;
	this.status=status;
	
	
}

@Id
@Column(name="device_id")
/*
@JsonIgnore
@JsonView(com.dev.mgm.Test.class)
*/
public long getDevice_id() {
	return device_id;
}
public void setDevice_id(long device_id) {
	this.device_id = device_id;
}

@Temporal(TemporalType.TIMESTAMP)
@Column(name="validTill")
@CreationTimestamp

public Date getValid_till() {
	return valid_till;
}

public void setValid_till(Date valid_till) {
	this.valid_till = valid_till;
}
@Enumerated(EnumType.STRING)
public DeviceStatus getStatus() {
	return status;
}

public void setStatus(DeviceStatus status) {
	this.status = status;
}

}
