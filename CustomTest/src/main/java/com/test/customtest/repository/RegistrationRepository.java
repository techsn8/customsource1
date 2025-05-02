package com.test.customtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.customtest.model.User;

public interface RegistrationRepository extends JpaRepository<User, Integer> {

	public User findByEmailId(String email);

	public User findByEmailIdAndPassword(String email, String password);

}
