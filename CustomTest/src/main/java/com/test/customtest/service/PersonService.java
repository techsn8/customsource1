package com.test.customtest.service;

import java.util.List;

import com.test.customtest.model.Person;

public interface PersonService {

	
	public List<Person> fetchPerson();

	public Person savePerson(Person person);

	public Person updatePerson(Person person);

	public void removePerson(Long id);
}
