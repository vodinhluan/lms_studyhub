package com.studyhub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studyhub.repository.ClassRepository;
import com.studyhub.repository.UserRepository;
import com.studyhub.model.Class;
import com.studyhub.model.User;
import com.studyhub.model.User.Role;
@Service
public class ClassService {

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Class> getAllClasses() {
        return (List<Class>) classRepository.findAll();
    }

    public Optional<Class> getClassById(Integer id) {
        return classRepository.findById(id);
    }

    public Class saveClass(Class clazz) {
        return classRepository.save(clazz);
    }

    public void deleteClass(Integer id) {
        classRepository.deleteById(id);
    }

    public List<User> getTeachers() {
        return userRepository.findByRole(User.Role.Teacher);
    }
    public List<Class> getClassesByUser(User user) {
        if (user.getRole() == Role.Admin) {
            return getAllClasses();
        } else if (user.getRole() == Role.Teacher) {
            return classRepository.findByTeacher(user);
        } else if (user.getRole() == Role.Student) {
            return classRepository.findByStudentsContains(user);
        }
        return List.of();
    }

	
}