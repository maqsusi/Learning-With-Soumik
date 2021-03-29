package com.learning.learningWithSoumik.boostrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.learning.learningWithSoumik.model.User;
import com.learning.learningWithSoumik.repositories.UserRepository;


@Component
public class BootstrapData implements CommandLineRunner {

	private final UserRepository userRepository;
	
	
	public BootstrapData(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User eric = new User("Akshat", "Sood", "akshu.manutd@gmail.com", "Ramana@13");
		userRepository.save(eric);
		User soumik = new User("Soumik", "Bhatta", "soumik.bhatta@gmail.com", "Bhatta@13");
		userRepository.save(soumik);
		
		
		System.out.println("Started in Bootstrap Data");
		System.out.println("Number of Users: " + userRepository.count());
	}

}
