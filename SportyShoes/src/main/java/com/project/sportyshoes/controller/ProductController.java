package com.project.sportyshoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.sportyshoes.entity.Product;
import com.project.sportyshoes.exception.DataNotFoundException;
import com.project.sportyshoes.exception.DuplicateIdException;
import com.project.sportyshoes.service.ProductService;

@Controller
@RestController
@RequestMapping("product")
public class ProductController {

	@Autowired
	ProductService productService;

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String create(@ModelAttribute("product") Product product, @RequestParam String catogory_name) {
		try {
			int res;
			try {
				res = productService.create(product, catogory_name);
				return res + " Added";
			} catch (DataNotFoundException e) {
				return e.getMessage();
			}
		} catch (DuplicateIdException e) {
			return e.getMessage();
		}
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Product> findAll() {
		List<Product> products = productService.loadAll();
		return products;
	}

	@RequestMapping(value = "{name}", method = RequestMethod.GET)
	public List<Product> findByName(@PathVariable String name) {
		List<Product> products = productService.findProduct(name);
		return products;
	}
	
	@RequestMapping(value = "category/{category_name}", method = RequestMethod.GET)
	public List<Product> findByCatogory(@PathVariable String category_name) {
		List<Product> products = productService.findProduct(category_name,true);
		return products;
	}

}
