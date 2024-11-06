package com.spring.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.assignment.exception.InvalidCredentialsException;
import com.spring.assignment.model.User;
import com.spring.assignment.repository.ExecutiveRepository;

@Service
public class ExecutiveService {

	@Autowired
	private ExecutiveRepository studentRepository;

	public User verifyLogin(String username, String password) throws InvalidCredentialsException {
		
		return studentRepository.verifyLogin(username,password);
	}
}