package com.learning.learningWithSoumik.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.learning.learningWithSoumik.model.User;

public interface UserRepository extends CrudRepository<User, String> {
	
	User findByEmail(String email);
}
