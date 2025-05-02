package com.test.customtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.customtest.model.User;
import com.test.customtest.service.RegistrationService;

@RestController
public class RegistrationController {

	@Autowired
	private RegistrationService service;

	@PostMapping(value = "/registeruser")	
	@CrossOrigin(origins = "http://localhost:4200")
	public User saveUser(@RequestBody User user) throws Exception {
		String tempEmaild = user.getEmailId();
		if (tempEmaild != null && !"".equals(tempEmaild)) {
			User user2 = service.fetchUserUserByEmailId(tempEmaild);
			if (user2 != null) {
				throw new Exception("User with " + tempEmaild + " is already exist");
			}
		}
		User User1 = null;System.out.println("user name :::: "+user.getUserName());
		User1 = service.saveUser(user);
		return User1;
	}

	@PostMapping(value = "/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempEmailId = user.getEmailId();
		String temppassword = user.getPassword();
		User user1 = null;
		if (tempEmailId != null && temppassword != null) {
			user1 = service.fetchUserUserByEmailIdAndPassword(tempEmailId, temppassword);
		}
		if (user1 == null) {
			throw new Exception("Bad credentials");
		}
		return user1;
	}

}
