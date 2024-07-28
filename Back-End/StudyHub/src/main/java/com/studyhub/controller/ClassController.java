package com.studyhub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	 @DeleteMapping("/class/delete/{classId}")
	 public ResponseEntity<Void> deleteClass(@PathVariable("classId") Integer classId) {
	     try {
	    	 classService.deleteClass(classId);
	         return ResponseEntity.noContent().build(); 
	     } catch (Exception e) {
	         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); 
	     }
	 }
	
}
