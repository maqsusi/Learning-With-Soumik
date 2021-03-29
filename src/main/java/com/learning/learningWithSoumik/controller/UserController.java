package com.learning.learningWithSoumik.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learning.learningWithSoumik.model.User;
import com.learning.learningWithSoumik.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@RequestMapping("/users/{id}")
	public Optional<User> getUserById(@PathVariable String id) {
		return userService.getUserById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/users")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);	
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value = "/users/{id}") 
	public String deleteUser(@PathVariable String id) {
		return userService.deleteUser(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value = "/users/{id}")
	public User updateUser(@PathVariable String id, @RequestBody User user) {
		return userService.updateUser(id, user);
	}
	
	
	
}
