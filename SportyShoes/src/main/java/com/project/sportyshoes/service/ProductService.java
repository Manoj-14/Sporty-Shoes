package com.project.sportyshoes.service;

import java.util.List;


import com.project.sportyshoes.entity.Product;
import com.project.sportyshoes.exception.DataNotFoundException;
import com.project.sportyshoes.exception.DuplicateIdException;

import jakarta.transaction.Transactional;

public interface ProductService {
	@Transactional
	int create(Product product,String catogory_name) throws DuplicateIdException,DataNotFoundException;

	List<Product> loadAll();

	List<Product> findProduct(String name);

	List<Product> findProduct(String catogory_name,Boolean catogory);
}
