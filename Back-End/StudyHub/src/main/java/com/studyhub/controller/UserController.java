package com.studyhub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.studyhub.model.User;

import com.studyhub.service.UserService;

@RestController
public class UserController {
	
		@Autowired
		private UserService userService;
		 @Autowired
		private PasswordEncoder passwordEncoder;
		@GetMapping("/user/get-all")
		public List<User> getAllUsers() {
			return userService.listUser();
		}
		
		@PostMapping("/user/create") 
		public User createUser(@RequestBody User user) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			return userService.createUser(user);
		}
		
		@GetMapping("/user/username/exists/{username}")
	    public ResponseEntity<Boolean> checkUsernameExists(@PathVariable("username") String username) {
			boolean exists = userService.usernameExists(username);
			return ResponseEntity.ok(exists);
		}
		
		 @GetMapping("/user/email/exists/{email}")
		 public ResponseEntity<Boolean> checkEmailExists(@PathVariable("email") String email) {
	        boolean exists = userService.emailExists(email);
	        return ResponseEntity.ok(exists);
		}
}
