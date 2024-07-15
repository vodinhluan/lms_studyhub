package com.studyhub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studyhub.model.User;
import com.studyhub.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public List<User> listUser() {
		return (List<User>) userRepo.findAll();
	}
	
	public User createUser(User user) {
		return userRepo.save(user);
	}
	
	public boolean usernameExists(String username) {
		return userRepo.existsByUsername(username);
	}
	
	public boolean emailExists(String email) {
		return userRepo.existsByEmail(email);
	}
}
