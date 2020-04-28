package com.spring.bookapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.bookapp.model.Book;
import com.spring.bookapp.model.User;
import com.spring.bookapp.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;
	
	public List<Book> findByUserId(User user) {
		return bookRepository.findByUser(user);
	}

	public void saveBook(String bookName, Integer rating, User user) {
		Book book = new Book(bookName, rating, user);
		book = bookRepository.save(book);
		updateBooksInSession(user, book);
	}

	private void updateBooksInSession(User user, Book book) {
		List<Book> books = user.getBooks();
		if (books != null) {
			books.add(book);
		} else {
			books = new ArrayList<>();
			books.add(book);
		}
		user.setBooks(books);
	}

	public void deleteBook(Integer id) {
		bookRepository.deleteById(id);
	}
}
