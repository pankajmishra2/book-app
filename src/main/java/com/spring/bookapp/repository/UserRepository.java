package com.spring.bookapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.bookapp.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUserName(String userName);

}
