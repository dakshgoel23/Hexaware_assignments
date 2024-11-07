package com.spring.assignment.service;

import java.util.List;

import com.spring.assignment.model.Policy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.assignment.repository.PolicyRepository;

@Service
public class PolicyService {

	@Autowired
	private PolicyRepository policyRepository;

	public List<Policy> getAllPolicies() {
		return policyRepository.findAllpolicies();
	}

	public void enterpolicies(int id, int amount) {
	    policyRepository.enterpolicies(id,amount);
		
	}

	public void deletepolicy(int id) {
		policyRepository.deletepolicy(id);
		
	}

}
