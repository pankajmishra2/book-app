package com.spring.bookapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.bookapp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUserName(String userName);

}
