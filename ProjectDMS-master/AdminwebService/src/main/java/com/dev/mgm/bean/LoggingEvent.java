package com.dev.mgm.bean;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="logging_event")
public class LoggingEvent {
/*
 * CREATE TABLE logging_event 
  (
    timestmp         BIGINT NOT NULL,
    formatted_message  TEXT NOT NULL,
    logger_name       VARCHAR(254) NOT NULL,
    level_string      VARCHAR(254) NOT NULL,
    thread_name       VARCHAR(254),
    reference_flag    SMALLINT,
    arg0              VARCHAR(254),
    arg1              VARCHAR(254),
    arg2              VARCHAR(254),
    arg3              VARCHAR(254),
    caller_filename   VARCHAR(254) NOT NULL,
    caller_class      VARCHAR(254) NOT NULL,
    caller_method     VARCHAR(254) NOT NULL,
    caller_line       CHAR(4) NOT NULL,
    event_id          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY
  );
 * 
 * 
 */
	private char caller_line;
	private short reference_flag;
	private long timestmp;
	private String formatted_message,logger_name,level_string,thread_name,arg0,arg1,arg2,arg3,caller_filename,caller_class,caller_method;
	private long event_id;
	@JsonIgnore
	public char getCaller_line() {
		return caller_line;
	}
	public void setCaller_line(char caller_line) {
		this.caller_line = caller_line;
	}
	@JsonIgnore
	public short getReference_flag() {
		return reference_flag;
	}
	public void setReference_flag(short reference_flag) {
		this.reference_flag = reference_flag;
	}
	
	
	public Long getTimestmp() {
		return timestmp;
	}
	public void setTimestmp(Long timestmp) {
		this.timestmp = timestmp;
	}
	@Type(type="text")
	public String getFormatted_message() {
		return formatted_message;
	}
	public void setFormatted_message(String formatted_message) {
		this.formatted_message = formatted_message;
	}
	@JsonIgnore
	public String getLogger_name() {
		return logger_name;
	}
	public void setLogger_name(String logger_name) {
		this.logger_name = logger_name;
	}
	@JsonIgnore
	public String getLevel_string() {
		return level_string;
	}
	public void setLevel_string(String level_string) {
		this.level_string = level_string;
	}
	@JsonIgnore
	public String getThread_name() {
		return thread_name;
	}
	public void setThread_name(String thread_name) {
		this.thread_name = thread_name;
	}
	public String getArg0() {
		return arg0;
	}
	public void setArg0(String arg0) {
		this.arg0 = arg0;
	}
	public String getArg1() {
		return arg1;
	}
	public void setArg1(String arg1) {
		this.arg1 = arg1;
	}
	public String getArg2() {
		return arg2;
	}
	public void setArg2(String arg2) {
		this.arg2 = arg2;
	}
	public String getArg3() {
		return arg3;
	}
	public void setArg3(String arg3) {
		this.arg3 = arg3;
	}
	@JsonIgnore
	public String getCaller_filename() {
		return caller_filename;
	}
	public void setCaller_filename(String caller_filename) {
		this.caller_filename = caller_filename;
	}
	@JsonIgnore
	public String getCaller_class() {
		return caller_class;
	}
	public void setCaller_class(String caller_class) {
		this.caller_class = caller_class;
	}
	@JsonIgnore
	public String getCaller_method() {
		return caller_method;
	}
	public void setCaller_method(String caller_method) {
		this.caller_method = caller_method;
	}
	@Id
	@GeneratedValue
	public long getEvent_id() {
		return event_id;
	}
	public void setEvent_id(long event_id) {
		this.event_id = event_id;
	}
	
}
