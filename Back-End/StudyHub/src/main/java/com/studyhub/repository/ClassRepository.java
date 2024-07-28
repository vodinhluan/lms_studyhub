package com.studyhub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.studyhub.model.Class;
@Repository
public interface ClassRepository extends CrudRepository<Class, Integer> {

}
