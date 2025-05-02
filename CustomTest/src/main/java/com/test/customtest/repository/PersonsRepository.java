package com.test.customtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.customtest.model.Person;

@Repository
public interface PersonsRepository extends JpaRepository<Person, Long> {

}
