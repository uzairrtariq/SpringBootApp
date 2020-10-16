package com.digitifyassignment.rest.webservices.restfulwebservice.Customer;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	public EntityModel<Customer> getCustomer(@PathVariable int id) {
		Customer customer = service.getCustomer(id);
		
		//throw exception if user not found
		if(customer == null) throw new UserNotFoundException("id->" + id);
		
		//HATEOAS
		
		EntityModel<Customer> resource = EntityModel.of(customer);
		
		WebMvcLinkBuilder linkTo = 
				linkTo(methodOn(this.getClass()).getAllCusotmers());
		
		resource.add(linkTo.withRel("all-customers"));
		
		return resource;
		
//		return customer;
	}
	
	@PostMapping(path= "/customers")
	//using @RequestBody to it can be mapped correctly
	//using @Valid to enable validation
	public ResponseEntity<Object> createCustomer(@Valid @RequestBody Customer customer) {
		
		Customer savedCustomer = service.saveCustomer(customer);
		
		//HTTP entity to return a custom response
		//Successfully created notification
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedCustomer.getId()).toUri();
		
		
		//return proper return status back -> 201 created
		return ResponseEntity.created(location).build();
		
	}
	
	@DeleteMapping(path= "/customers/{id}")
	public void removeCustomer(@PathVariable int id) {
		
		Customer deletedCustomer = service.deleteCustomer(id);

		//throw exception if user not found
		if(deletedCustomer == null) throw new UserNotFoundException("id->" + id);
		
	}
	
	
	

}
