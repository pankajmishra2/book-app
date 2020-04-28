package com.spring.bookapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.bookapp.model.User;
import com.spring.bookapp.service.BookService;
import com.spring.bookapp.service.UserService;

@Controller
@RequestMapping("/book")
@SessionAttributes("user")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private UserService userService;

	@GetMapping("/add")
	public String showBookList(ModelMap model) {
		return "addBook";
	}
	
	@PostMapping("/bookList")
	public String addBook(ModelMap model, @RequestParam("bookName") String name, @RequestParam("rating") Integer rating) {
		User user = (User)model.get("user");
		bookService.saveBook(name, rating, user);
		return "redirect:bookList";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Integer id) {
		bookService.deleteBook(id);
		return "redirect:../bookList";
	}
	
	@GetMapping("/bookList")
	public String getBookList(ModelMap model) {
		User user = (User)model.get("user");
		model.put("books", bookService.findByUserId(user));
		return "welcome";
	}
}
