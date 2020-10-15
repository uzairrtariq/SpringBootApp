package com.digitifyassignment.rest.webservices.restfulwebservice.Customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	//Dependency Injection -> its being injected in
	@Autowired
	private CustomerDaoService service;
	
	//Methods
	
	//Get all customers
	@GetMapping(path = "/customers")
	public List<Customer> getAllCusotmers(){
		return service.findAllCustomers();
	}
	
	//Get specific customer
	@GetMapping (path = "/customers/{id}")
	public Customer getCustomer(@PathVariable int id) {
		return service.getCustomer(id);
	}
	
	@PostMapping(path= "/customers")
	//using @requestbody to it can be mapped correctly
	public void createCustomer(@RequestBody Customer customer) {
		Customer savedCustomer = service.saveCustomer(customer);
		
	}
	
	
	

}
