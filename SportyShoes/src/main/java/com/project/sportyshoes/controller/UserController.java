package com.project.sportyshoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.sportyshoes.entity.User;
import com.project.sportyshoes.exception.DataNotFoundException;
import com.project.sportyshoes.exception.DuplicateIdException;
import com.project.sportyshoes.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String create(@ModelAttribute("user") User user) {
		try {
			return userService.create(user);
		} catch (DuplicateIdException e) {
			return e.getMessage();
		}
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<User> loadAll() {
		return userService.loadAll();
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public Object loadAll(@RequestParam String email, @RequestParam String password) {
		try {
			User user = userService.getUser(email, password);
			return user;
		} catch (DataNotFoundException e) {
			return e.getMessage();
		}
	}
}
