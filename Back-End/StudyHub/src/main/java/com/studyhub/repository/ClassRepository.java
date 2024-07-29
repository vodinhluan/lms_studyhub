package com.studyhub.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.studyhub.model.Class;
import com.studyhub.model.User;
@Repository
public interface ClassRepository extends CrudRepository<Class, Integer> {

	List<Class> findByTeacher(User user);

	List<Class> findByStudentsContains(User user);

}
