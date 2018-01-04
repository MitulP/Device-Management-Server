package com.admin.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.admin.bean.Admin;
import com.dev.mgm.db.MySessionFactory;

/**
 *@author Asif
 *@date 16/12/2017
 */

public class ChangePasswordDAO {
	
	public boolean checkPassword(Admin a) {
		/*
		 * TODO : checks the current password entered by user
		 */
		SessionFactory sf=MySessionFactory.getSessionFactory();
		Session session=sf.openSession();
		Admin admin;
		Transaction tx=session.beginTransaction();
		admin=session.get(Admin.class,1);

		if(a.getPassword().equals(admin.getPassword())) {
			
			admin.setPassword(a.getNewPassword());
			
			tx.commit();
			return true;
			
		}
		else{
			return false;
		}
		
	}

}
