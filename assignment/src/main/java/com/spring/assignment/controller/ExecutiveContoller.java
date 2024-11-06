package com.spring.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.assignment.exception.InvalidCredentialsException;
import com.spring.assignment.model.Executive;
import com.spring.assignment.model.Policy;
import com.spring.assignment.model.User;
import com.spring.assignment.service.ExecutiveService;
import com.spring.assignment.service.PolicyService;



import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ExecutiveContoller {

	@Autowired
	private ExecutiveService executiveService;
	
	@Autowired
	private PolicyService policyService;

	@GetMapping("/")
	public String showLogin() {
		return "login";
	}
	
	@GetMapping("/login-form")
	public String handleLogin(HttpServletRequest req) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		try {
			User user =  executiveService.verifyLogin(username,password);
			if(user.getRole().equalsIgnoreCase("Executive")) {
				req.setAttribute("username", username);
				return "dashboard"; 
			}
		} catch (InvalidCredentialsException e) {
			req.setAttribute("msg",e.getMessage());
			return "login";
		}
		return null; 
	}
	
	@GetMapping("/showAllPolicies")
	public String showAllProducts(HttpServletRequest req) {
		List<Policy> policies = policyService.getAllPolicies();
		req.setAttribute("policies", policies); // Pass products to the view
		return "policylist";  // productsList.html view
	}
	
	@GetMapping("/dashboard")
	public String showdashboard(HttpServletRequest req) {
		return "dashboard";
	}
	
	@GetMapping("/addpolicy")
	public String gotoaddpolicyform(HttpServletRequest req, HttpSession session)
	{
		return "addpolicy";
	}
	@GetMapping("/add-policy")
	public String enterpolicy(HttpServletRequest req, HttpSession session)
	{
		int id=Integer.parseInt(req.getParameter("id"));
		int amount=Integer.parseInt(req.getParameter("amount"));
		policyService.enterpolicies(id,amount);
		return "enroll-confirm";
	}
	
	@GetMapping("/deletepolicy")
	public String deletepolicy(HttpServletRequest req,HttpSession session)
	{
		return "deletepolicy";
	}
	
	@GetMapping("/delete-policy")
	public String deactivatepolicy(HttpServletRequest req,HttpSession session)
	{
		int id=Integer.parseInt(req.getParameter("id"));
		policyService.deletepolicy(id);
		return "enroll-confirm";
	}
	
	
	
	
}
