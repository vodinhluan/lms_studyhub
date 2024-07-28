package com.studyhub.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.studyhub.model.User;

import jakarta.transaction.Transactional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
	User findByUsername(String username);
	  List<User> findByRole(User.Role role);
}
