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

import com.studyhub.model.Class;
import com.studyhub.model.User;
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
	 @GetMapping("/class/detail/{classId}")
	 public ResponseEntity<Class> getClassDetail(@PathVariable("classId") Integer classId) {
		 Optional<Class> lop = classService.getClassById(classId);
		 if (lop.isPresent()) {
			 return ResponseEntity.ok(lop.get());
		 } else {
			 return ResponseEntity.notFound().build();
		 }			 
	 }
	 
	 @PutMapping("/class/update/{classId}")
	 public ResponseEntity<Class> updateClass(@PathVariable("classId") Integer classId, 
			 @RequestBody Class updatedClass) {
		 Optional<Class> lop = classService.getClassById(classId);
		 if (lop.isPresent()) {
			 Class existingClass = lop.get(); 
			 existingClass.setName(updatedClass.getName());
			 existingClass.setTeacher(updatedClass.getTeacher());
			 classService.saveClass(existingClass);
			 return ResponseEntity.ok(existingClass);
		 } else {
			 return ResponseEntity.notFound().build();
		 }
		 
	 }
	
}
