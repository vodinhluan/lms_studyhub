package com.studyhub.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.studyhub.model.User;

import com.studyhub.service.UserService;

@RestController
public class UserController {
	
		@Autowired
		private UserService userService;
		
		@GetMapping("/user/get-all")
		public List<User> getAllUsers() {
			return userService.listUser();
		}
		
		@PostMapping("/user/create") 
		public User createUser(@RequestBody User user) {
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
		 
		 @DeleteMapping("/user/delete/{userId}")
		 public ResponseEntity<Void> deleteUser(@PathVariable("userId") Integer userId) {
		     try {
		         userService.deleteUser(userId);
		         return ResponseEntity.noContent().build(); 
		     } catch (Exception e) {
		         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // Handle any exception properly
		     }
		 }
		 
		 @GetMapping("/user/detail/{userId}")
		 public ResponseEntity<User> getUserDetail(@PathVariable("userId") Integer userId) {
			 Optional<User> user = userService.findUserById(userId);
			 if (user.isPresent()) {
				 return ResponseEntity.ok(user.get());
			 } else {
				 return ResponseEntity.notFound().build();
			 }			 
		 }
		 
		 @PutMapping("/user/update/{userId}")
		 public ResponseEntity<User> updateUser(@PathVariable("userId") Integer userId, 
				 @RequestBody User updatedUser) {
			 Optional<User> user = userService.findUserById(userId);
			 if (user.isPresent()) {
				 User existingUser = user.get(); // phep tro?
				 existingUser.setUsername(updatedUser.getUsername());
				 existingUser.setPassword(updatedUser.getPassword());
				 existingUser.setEmail(updatedUser.getEmail());
				 existingUser.setFullName(updatedUser.getFullName());
				 existingUser.setRole(updatedUser.getRole());
			     userService.saveUser(existingUser);
				 return ResponseEntity.ok(existingUser);
			 } else {
				 return ResponseEntity.notFound().build();
			 }
			 
		 }

}
