package com.test.customtest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.customtest.model.Person;
import com.test.customtest.service.PersonService;

@RestController
@RequestMapping("/service")
public class ServiceController {

	@Autowired
	PersonService service;

	@GetMapping(value = "/str")
	public String fecthService() {

		return "welcome Service root_2025";
	}

	@GetMapping(value = "/retievePersons")

	public List<Person> fecthPersons() {
		List<Person> p1 = service.fetchPerson();
		return p1;

	}

	@PostMapping(value = "/createPersons")
	public Person SavePersons(@RequestBody Person person) {

		System.out.println("starting>>>>>>>>>>   ");
		System.out.println("fname" + person.getpFirstName());
		System.out.println("fname" + person.getpLastName());
		System.out.println("fname" + person.getpAddress());
		System.out.println("ending>>>>>>>>>>   ");

		return service.savePerson(person);
	}

	@PutMapping(value = "/updatePerson/{id}")
	public Person updatePerson(@RequestBody Person person, @PathVariable Long id) {
		person.setId(id);
		System.out.println("starting>>>>>>>>>>   ");
		System.out.println("fname" + person.getpFirstName());
		System.out.println("fname" + person.getpLastName());
		System.out.println("fname" + person.getpAddress());
		System.out.println("ending>>>>>>>>>>   ");

		return service.updatePerson(person);
	}

	@DeleteMapping(value = "/removePerson/{id}")
	public String removePerson(@PathVariable Long id) {
		System.out.println("starting>>>>>>>>>>   ");
		System.out.println("id" + id);
		System.out.println("ending>>>>>>>>>>   ");
		service.removePerson(id);
		return "Removed person which is having id is::: " + id;
	}
}
