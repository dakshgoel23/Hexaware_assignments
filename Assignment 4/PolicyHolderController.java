package com.springboot.insurance_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.insurance_app.dto.ResponseMessageDto;
import com.springboot.insurance_app.exception.ResourceNotFoundException;
import com.springboot.insurance_app.model.Policy;
import com.springboot.insurance_app.model.PolicyHolder;
import com.springboot.insurance_app.service.PolicyHolderService;

@RestController
public class PolicyHolderController {
	
	@Autowired
	private PolicyHolderService policyholderservice;
	
	@PostMapping("/policyholder/add")
	public PolicyHolder addpolicyholder(@RequestBody PolicyHolder policyholder)
	{
		return policyholderservice.insert(policyholder);
	}
	
	@GetMapping("/policyholder/viewall")
	public List<PolicyHolder> getAll()
	{
		List<PolicyHolder> list=policyholderservice.viewall();
		return list;
	}
	
	@DeleteMapping("/policyholder/delete/{id}")
	public ResponseEntity<?> deletePolicyHolder(@PathVariable int id, ResponseMessageDto dto) {
	
		try {
			policyholderservice.validate(id);
			policyholderservice.delete(id);
		} catch (ResourceNotFoundException e) {
			dto.setMsg(e.getMessage());
			return ResponseEntity.badRequest().body(dto);
		} 
		dto.setMsg("Policyholder deleted");
		return ResponseEntity.ok(dto);
		
	}
	
	@PostMapping("/policyholder/batch/add")
	public List <PolicyHolder> batchInsert(@RequestBody List<PolicyHolder> list) {
		return policyholderservice.insertInBatch(list);
	}
	
	@PutMapping("/policyholder/update/{id}")
	public ResponseEntity<?> updatePolicyHolder(@PathVariable int id, @RequestBody PolicyHolder newPolicyHolder,ResponseMessageDto dto) {
		try {
			PolicyHolder existingPolicyHolderDb = policyholderservice.validate(id);
			if(newPolicyHolder.getName() != null)
				existingPolicyHolderDb.setName(newPolicyHolder.getName());
			if(newPolicyHolder.getContact() != null)
				existingPolicyHolderDb.setContact(newPolicyHolder.getContact());
			if(newPolicyHolder.getPannumber() != null)
				existingPolicyHolderDb.setPannumber(newPolicyHolder.getPannumber());
			if(newPolicyHolder.getAge() != 0)
				existingPolicyHolderDb.setAge(newPolicyHolder.getAge());
			
			//re save this existing policy having new updated value 
			existingPolicyHolderDb = policyholderservice.insert(existingPolicyHolderDb);
			return ResponseEntity.ok(existingPolicyHolderDb);
		} catch (ResourceNotFoundException e) {
			dto.setMsg(e.getMessage());
			return ResponseEntity.badRequest().body(dto);
		}
	}

}
