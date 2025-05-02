package com.test.customtest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.customtest.model.Person;
import com.test.customtest.repository.PersonsRepository;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonsRepository repository;
	
	@Override
	public List<Person> fetchPerson() {
		List<Person> p1=new ArrayList<>();
		p1=repository.findAll();
		return p1;
		
	}
	
	@Override
	public Person savePerson(Person person) {
		return repository.save(person);
	}

	@Override
	public Person updatePerson(Person person) {
		return repository.saveAndFlush(person);
	}

	@Override
	public void removePerson(Long id) {
		 repository.deleteById(id);
	}

}
