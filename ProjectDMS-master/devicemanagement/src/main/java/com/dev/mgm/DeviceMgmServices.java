package com.dev.mgm;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dev.mgm.bean.Device;
import com.dev.mgm.bean.MessageBean;
import com.dev.mgm.bean.User;
import com.dev.mgm.user.controller.UserController;

@RestController
@RequestMapping("/device")
public class DeviceMgmServices {

	@RequestMapping(value="/register",method=RequestMethod.POST)
	public MessageBean registerUser(@RequestBody User u) {
		//TODO method for register user
		MessageBean m=UserController.registerUser(u);
		return m;
	}
	@RequestMapping("/check/{device_id}")
	public Device checkDeviceStatus(@PathVariable String device_id) {
		//TODO method for check device status
		return UserController.checkDeviceStatus(Long.parseLong(device_id));
	}
	
	@RequestMapping("/deregister/{device_id}")
	public MessageBean deRegister(@PathVariable String device_id) {
		
		//TODO method for deregister user
		MessageBean m=UserController.deRegisterUser(Long.parseLong(device_id));
		return m;
		
	}
}
