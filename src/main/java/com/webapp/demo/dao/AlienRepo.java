package com.webapp.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;
import org.springframework.web.bind.annotation.PathVariable;

import com.webapp.demo.model.*;

public interface AlienRepo extends CrudRepository<Alien, Integer> {
	List<Alien> findByLang(String lang);
	List<Alien> findAll();
	@Query("from Alien where aid = ?1")
	List<Alien> findAllById(int aid);
	@Query("from Alien where aid = ?1")
	Alien getOne(int aid);
}
