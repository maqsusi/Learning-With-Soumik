package com.learning.learningWithSoumik.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.learningWithSoumik.model.User;
import com.learning.learningWithSoumik.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public List<User> getAllUsers() {
		return (List<User>) userRepository.findAll();
	}
	
	public Optional<User> getUserById(String id) {
		if (id != null) {
			return userRepository.findById(id);
		}
		
		return null;
		
	}
	
	public User addUser(User user) {
		userRepository.save(user);
		return userRepository.findByEmail(user.getEmail());
	}
	
	public String deleteUser(String id) {
		if (id != null) {
			Optional<User> user = userRepository.findById(id);
			if (user != null) {
				userRepository.deleteById(id);
				return "User " + user.get().getFirstname() + " " + user.get().getLastname() + " deleted successfully";
			}
			else {
				return "User not found for id = " + id;
			}
			
		}
		
		return "Please send a valid id";
	}
	
	public User updateUser(String id, User user) {
		if (id != null) {
			User updatedUser = userRepository.findById(id).get();
			updatedUser.setEmail(user.getEmail());
			updatedUser.setFirstname(user.getFirstname());
			updatedUser.setLastname(user.getLastname());
			updatedUser.setPassword(user.getPassword());
			
			userRepository.save(updatedUser);
			
			return updatedUser;
		}
		
		return null;
		
	}
}
