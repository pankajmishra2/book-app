package com.spring.bookapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.bookapp.model.Book;
import com.spring.bookapp.model.User;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	
	public List<Book> findByUser(User user);
	
}
