package com.webapp.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.webapp.demo.model.Person;

public interface PersonRepo extends CrudRepository<Person, Integer>  {
	
	List <Person> findAll();
	@Query("from Person where pid = ?1")
	List <Person> findById(int pid);

}
