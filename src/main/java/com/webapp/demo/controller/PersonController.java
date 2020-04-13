package com.webapp.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.demo.dao.PersonRepo;
import com.webapp.demo.exception.PersonControllerException;
import com.webapp.demo.exception.PersonNotfoundException;
import com.webapp.demo.model.Person;

@RestController
public class PersonController {
	
	@Autowired
	PersonRepo repo;
	
	@GetMapping("/person")
	public String getPerson() {	
		return "hello";
	}
	
	@GetMapping("/person/{pid}")
	public List<Person> getByID(@PathVariable int pid){
		
		List<Person> per = repo.findById(pid);
		
		if(per.size()==0) {
			throw new PersonNotfoundException();
		}
		
		return repo.findById(pid);
	}

}
