package com.coffeebreak.coffeebreak.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coffeebreak.coffeebreak.model.User;
import com.coffeebreak.coffeebreak.repository.UserRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/user")
	public ResponseEntity<List<User>> getAllUsers() {
		try {
			return new ResponseEntity<List<User>>(userRepository.findAll(), HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/user")
	public ResponseEntity<User> createTutorial(@RequestBody User user) {
		try {
			User _user = userRepository.save(new User(user.getNome(),user.getCpf(),user.getEmail(),user.getAlimento() ));
			return new ResponseEntity<User>(_user, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getTutorialById(@PathVariable("id") Long  id) {
		Optional userData = userRepository.findById(id);
		if (userData.isPresent()) {
			return new ResponseEntity(userData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@DeleteMapping("/user")
	public ResponseEntity<HttpStatus> deleteAllTutorials() {
		try {
			userRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
