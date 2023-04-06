package com.project.sportyshoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.sportyshoes.entity.Admin;
import com.project.sportyshoes.exception.DataNotFoundException;
import com.project.sportyshoes.exception.DuplicateIdException;
import com.project.sportyshoes.service.AdminService;

@Controller
@RestController
@RequestMapping("admin")
public class AdminController {

	@Autowired
	AdminService adminService;

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String create(@ModelAttribute Admin admin) {
		int res;
		try {
			res = adminService.create(admin);
			return res + " Added";
		} catch (DuplicateIdException e) {
			return e.getMessage();
		}
	}

	@RequestMapping(value = "{email}", method = RequestMethod.GET)
	public Object find(@PathVariable String email) {
		Admin admin;
		try {
			admin = adminService.find(email);
			return admin;
		} catch (DataNotFoundException e) {
			return e.getMessage();
		}
	}

	@RequestMapping(value = "{email}", method = RequestMethod.POST)
	public Object find(@PathVariable String email, @ModelAttribute("password") String password) {
		Admin admin;
		try {
			admin = (Admin) adminService.find(email, password);
			return admin;
		} catch (DataNotFoundException e) {
			return e.getMessage();
		}
	}

	@RequestMapping("/")
	public String index() {
		return "index";
	}
}
