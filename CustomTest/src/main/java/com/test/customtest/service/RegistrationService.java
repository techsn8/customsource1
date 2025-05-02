package com.test.customtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.customtest.model.User;
import com.test.customtest.repository.RegistrationRepository;

@Service
public class RegistrationService {

	@Autowired
	RegistrationRepository repository;
	
	public User saveUser(User user) {
		return  repository.save(user);
		
	}


	public User fetchUserUserByEmailId(String email) {
		return repository.findByEmailId(email);
		 
	}
	
	public User fetchUserUserByEmailIdAndPassword(String email, String password) {
		return repository.findByEmailIdAndPassword(email,password);
		 
	}

}
