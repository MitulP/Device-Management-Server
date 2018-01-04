package com.dev.mgm.bean;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;






public class LoggingEventJSON {
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
	
	public  LoggingEventJSON(LoggingEvent e) {
		this.timestmp=e.getTimestmp();
		this.formatted_message=e.getFormatted_message();
		this.arg0=e.getArg0();
		this.arg1=e.getArg1();
		this.arg2=e.getArg2();
		this.arg3=e.getArg3();
		this.event_id=e.getEvent_id();
	}

	private long timestmp;
	private String formatted_message,arg0,arg1,arg2,arg3;
	private long event_id;

	
	public String getTimestmp() {
			Date date=new Date(timestmp);
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a"); 
		   sdf.setTimeZone(TimeZone.getTimeZone("GMT+1"));
		   String formattedDate = sdf.format(date);
		    return formattedDate;
	}
	public void setTimestmp(Long timestmp) {
		this.timestmp = timestmp;
	}
	
	public String getFormatted_message() {
		return formatted_message;
	}
	public void setFormatted_message(String formatted_message) {
		this.formatted_message = formatted_message;
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
	
	public long getEvent_id() {
		return event_id;
	}
	public void setEvent_id(long event_id) {
		this.event_id = event_id;
	}
	
}
