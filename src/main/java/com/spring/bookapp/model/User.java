package com.spring.bookapp.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	
	public User() {
		
	}
	
	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	@Id
	@GeneratedValue
	private Integer id;

	private String userName;
	
	private String password;
	
	@OneToMany(mappedBy="user")
	private List<Book> books;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}
