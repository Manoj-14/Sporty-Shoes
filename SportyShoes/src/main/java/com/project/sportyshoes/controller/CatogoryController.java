package com.project.sportyshoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.sportyshoes.entity.Category;
import com.project.sportyshoes.exception.DataNotFoundException;
import com.project.sportyshoes.exception.DuplicateIdException;
import com.project.sportyshoes.service.CategoryService;

@Controller
@RestController
@RequestMapping("category")
public class CatogoryController {
	@Autowired
	CategoryService categoryService;

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String create(@RequestBody Category catogory) {
		try {
			int res = categoryService.create(catogory);
			return res + " Added";
		} catch (DuplicateIdException e) {
			return e.getMessage();
		}
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Category> loadAll() {
		List<Category> catogories = categoryService.findAll();
		return catogories;
	}

	@RequestMapping(value = "{name}", method = RequestMethod.GET)
	public Object findByName(@PathVariable String name) {
		Category catogory;
		try {
			catogory = categoryService.find(name);
			return catogory;
		} catch (DataNotFoundException e) {
			return e.getMessage();
		}
	}

}
