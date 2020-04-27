package com.spring.bookapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.bookapp.model.User;
import com.spring.bookapp.service.UserService;


@Controller
@SessionAttributes("id")
@RequestMapping("/book")
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value= {"", "/"})
	public String showWelcomePage() {
		return "index";
	}

	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}
	
	@PostMapping("/login")
	public String doLogin(ModelMap model, @RequestParam("username") String userName, @RequestParam("password") String password) {
		userName = userName.toLowerCase();
		password = password.toLowerCase();
		if(!userName.equals(password)) {
			model.put("errorMessage", "invalid credentials !!!");
			return "login";
		} else {
			User user = userService.getUser(userName, password);
			model.put("user", user);
			model.put("id", user.getId());
			return "welcome";
		}
	}
	
	
	@GetMapping("/book")
	public String addBook(@RequestParam("name") String bookName, @RequestParam("rating") int rating) {
		System.out.println("Book Name : "+ bookName+", rating = "+rating);
		return "book added successfully";
	}
	
	
}