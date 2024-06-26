package com.studyhub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
