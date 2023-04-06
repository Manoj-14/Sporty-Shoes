package com.project.sportyshoes.service;

import com.project.sportyshoes.entity.Admin;
import com.project.sportyshoes.exception.DataNotFoundException;
import com.project.sportyshoes.exception.DuplicateIdException;

public interface AdminService {
	int create(Admin admin) throws DuplicateIdException;

	Admin find(String email) throws DataNotFoundException;
	
	boolean exists(String email);
	
	Object find(String email,String password) throws DataNotFoundException;
}