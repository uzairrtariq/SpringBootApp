package com.digitifyassignment.rest.webservices.restfulwebservice.Customer;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
public class CustomerJPAController {
	
	//Dependency Injection -> its being injected in
	@Autowired
	private CustomerDaoService service;
	
	//Dependency Injection -> its being injected in
	@Autowired
	private CustomerRepo customerRepo;
	
	//Dependency Injection -> its being injected in
	@Autowired
	private CorderRepo orderRepo;
	
	
	//Methods
	
	//Get all customers
	@GetMapping(path = "/jpa/customers")
	public List<Customer> getAllCusotmers(){
		return customerRepo.findAll();
	}
	
	//Get specific customer
	@GetMapping (path = "/jpa/customers/{id}")
	public EntityModel<Customer> getCustomer(@PathVariable int id) {
		
		//using optional class to handle null or not
		Optional<Customer> customer = customerRepo.findById(id);
		
		
		
		//throw exception if user not found
		if(!customer.isPresent()) throw new UserNotFoundException("id->" + id);
		
		//HATEOAS
		
		EntityModel<Customer> resource = EntityModel.of(customer.get());
		
		WebMvcLinkBuilder linkTo = 
				linkTo(methodOn(this.getClass()).getAllCusotmers());
		
		resource.add(linkTo.withRel("all-customers"));
		
		return resource;
		
//		return customer;
	}
	
	@PostMapping(path= "/jpa/customers")
	//using @RequestBody to it can be mapped correctly
	//using @Valid to enable validation
	public ResponseEntity<Object> createCustomer(@Valid @RequestBody Customer customer) {
		
		Customer savedCustomer = customerRepo.save(customer);
		
		//HTTP entity to return a custom response
		//Successfully created notification
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedCustomer.getId()).toUri();
		
		
		//return proper return status back -> 201 created
		return ResponseEntity.created(location).build();
		
	}
	
	@DeleteMapping(path= "/jpa/customers/{id}")
	public void removeCustomer(@PathVariable int id) {
		customerRepo.deleteById(id);
		
	}
	
	//Get all the orders for a specific customer
	@GetMapping("/jpa/customers/{id}/order")
	public List<Corder> getAllOrders(@PathVariable int id){
		Optional<Customer> customerOptional = customerRepo.findById(id);
		
		//throw exception if user not found
		if(!customerOptional.isPresent()) throw new UserNotFoundException("id->" + id);
		
		return customerOptional.get().getOrders();
		
	}
	
	//Create an order for a customer
	@PostMapping("/jpa/customers/{id}/posts")
	public ResponseEntity<Object> createOrder(@PathVariable int id, @RequestBody Corder order) {

		Optional<Customer> savedCustomer = customerRepo.findById(id);
		
		// throw exception if user not found
		if (!savedCustomer.isPresent())
			throw new UserNotFoundException("id->" + id);
		
		Customer customer = savedCustomer.get();
		
		//Assign the correct customer to the order
		order.setCustomer(customer);
		
		//Save the order
		orderRepo.save(order);
		
		

		// HTTP entity to return a custom response
		// Successfully created notification
		//now need to append the ID of order 
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(order.getId()).toUri();

		// return proper return status back -> 201 created
		return ResponseEntity.created(location).build();

	}
	
	
	
	
	

}
