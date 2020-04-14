package com.webapp.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.demo.dao.AlienRepo;
import com.webapp.demo.model.Alien;

@RestController
public class AlienController {
	
	@Autowired
	AlienRepo repo;

//	@RequestMapping("/")
//	public String home() {
//		return "home";
//	}
//	
	@PostMapping("/alien")
	public Alien addAlien(Alien alien) {
		repo.save(alien);
		return alien;
	}
	
	@DeleteMapping("/alien/{aid}")
	public String deleteAlien(@PathVariable("aid") int aid ) {
		Alien a = repo.getOne(aid);
		repo.delete(a);
		return "deleted";
	}
	
	@PutMapping("/alien")
	public Alien saveOrUpdateAlien(Alien alien) {
		repo.save(alien);
		return alien;
	}
	
	@GetMapping(path = "/aliens", produces = "application/xml")
	public List<Alien> getAliens() {
		List<Alien> allAliens = new ArrayList<Alien>();
		allAliens = repo.findAll();
		return allAliens;
	}
	
	@GetMapping("/alien/{aid}")
	public List<Alien> getAlien(@PathVariable("aid") int aid) {
		List<Alien> aliens = new ArrayList<Alien>();
		aliens = repo.findAllById(aid);
		return aliens;
	}
	
	
	
	
	
}
