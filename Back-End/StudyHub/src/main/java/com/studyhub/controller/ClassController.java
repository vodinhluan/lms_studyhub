package com.studyhub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.studyhub.model.Class;
import com.studyhub.service.ClassService;
@RestController
public class ClassController {
	@Autowired
	private ClassService classService;
	@GetMapping("/class/get-all")
	public List<Class> getAllClasses() {
		return classService.getAllClasses();
	}
	
	@PostMapping("/class/create") 
	public Class createClass(@RequestBody Class clazz) {
		return classService.saveClass(clazz);
	}
	
}
