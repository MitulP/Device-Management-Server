package com.dev.mgm.bean;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarBigIntType extends org.hibernate.type.CalendarType {
   /*Calendar cal;
	public Object get(ResultSet rs, String name) {
		GregorianCalendar gd= new GregorianCalendar();
		try {
			gd.setTime(new Date(rs.getLong(name)));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cal;
    }
    public void set(PreparedStatement stmt, Object value, int index) {
        stmt.setParameter(index, ((Calendar) value).getTime());
    }
*/}