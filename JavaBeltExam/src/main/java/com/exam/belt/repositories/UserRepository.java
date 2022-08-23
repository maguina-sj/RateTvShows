package com.exam.belt.repositories;

import org.springframework.data.repository.CrudRepository;

import com.exam.belt.models.User;

public interface UserRepository extends CrudRepository<User, Long>{
	User findByEmail(String email);

}
