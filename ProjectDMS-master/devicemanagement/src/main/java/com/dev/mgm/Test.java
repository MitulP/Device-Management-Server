package com.dev.mgm;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dev.mgm.bean.Device;
import com.dev.mgm.bean.DeviceStatus;
import com.dev.mgm.bean.MessageBean;
import com.dev.mgm.bean.User;
import com.dev.mgm.db.MySessionFactory;
import com.dev.mgm.user.controller.UserController;

@RestController
@RequestMapping("/test")
public class Test {

	@RequestMapping("/register")
	public MessageBean registerUser() {
		MessageBean m=UserController.registerUser(new User());
		return m;
	}
	@RequestMapping("/check/{device_id}")
	public Device checkDeviceStatus(@PathVariable String device_id) {
		
		return UserController.checkDeviceStatus(Long.parseLong(device_id));
	}
	
	@RequestMapping(value="/send", method=RequestMethod.POST)
	
	
	public String register(@RequestBody User u) {
		System.out.println(u.getUser_id());
		System.out.println(u.getName());
		/*System.out.println(u.getHandleDev().getDevice_id());
		System.out.println(u.getHandleDev().getStatus());
		System.out.println(u.getHandleDev().getValid_till());*/
		
		
		
		
		
		return "Hello";
		
		
	}
@RequestMapping(value="/view", method=RequestMethod.POST)
	
	public User view() {
	User u=new User();
		
		
		u.setName("Danny");
		/*u.setHandleDev(new Device(1,null,DeviceStatus.REGISTER));*/
		
		return u;
		
		
		
	}
@RequestMapping(value="/viewall", method=RequestMethod.GET)
	
	public List<User> viewAll() {
	
		SessionFactory sf=MySessionFactory.getSessionFactory();
		Session session=sf.openSession();
		Query q=session.createQuery("From com.dev.mgm.bean.User");
		q.setFirstResult(0);
		q.setMaxResults(500);
	
		List<User> user=q.list();
		return user;
		
		
	}
}
