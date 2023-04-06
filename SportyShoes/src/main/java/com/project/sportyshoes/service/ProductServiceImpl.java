package com.project.sportyshoes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sportyshoes.entity.Category;
import com.project.sportyshoes.entity.Product;
import com.project.sportyshoes.exception.DataNotFoundException;
import com.project.sportyshoes.exception.DuplicateIdException;
import com.project.sportyshoes.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	CategoryService categoryService;

	@Override
	public int create(Product product, String category_name) throws DuplicateIdException, DataNotFoundException {
		try {
			Category category = categoryService.find(category_name);
			product.setCatogory(category);
			int id = productRepository.save(product).getId();
			return id;
		} catch (DataNotFoundException e) {
			throw new DataNotFoundException();
		}
	}

	@Override
	public List<Product> loadAll() {
		List<Product> products = (List<Product>) productRepository.findAll();
		return products;
	}

	@Override
	public List<Product> findProduct(String name) {
		List<Product> products = productRepository.findByName(name);
		return products;
	}

	@Override
	public List<Product> findProduct(String name, Boolean catogory) throws DataNotFoundException {
		List<Product> products = productRepository.findByCategoryName(name);
		if (products.size() <= 0) {
			throw new DataNotFoundException();
		} else {
			return products;
		}
	}

}
