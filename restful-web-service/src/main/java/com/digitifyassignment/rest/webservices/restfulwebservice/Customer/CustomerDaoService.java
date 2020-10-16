package com.digitifyassignment.rest.webservices.restfulwebservice.Customer;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

//You can also use @repository
@Component
public class CustomerDaoService {
	
	//CustomerCounter = 4, because there are 4 customers
		private static int customersCount = 4;
	
	//using simple ArrayList here
	private static List<Customer> customers = new ArrayList<>();
	
	
	
	//Add bogus customers, adding 4
	//Static block
	static {
		customers.add(new Customer(1, "Uzair", new Date()));
		customers.add(new Customer(2, "Bilal", new Date()));
		customers.add(new Customer(3, "Moueez", new Date()));
		customers.add(new Customer(4, "Azeem", new Date()));
	}
	
	//Methods to support the data
	
	
	
	
	//retrieve all users #1
	public List<Customer> findAllCustomers(){
		return customers;
	}
	
	//retrieve user #2
	public Customer getCustomer(int id) {
		
		//for customers in the ArrayList if ID matches, return that Customer
		for (Customer customer:customers) {
			if(customer.getId() == id) {
				return customer;
			}
		}
		//If it is not present, then return null
		return null;
		
	}
	
	//Save new user #3
	public Customer saveCustomer(Customer customer) {
		//if it has no ID
		if(customer.getId() == null) {
			//give a new ID by incrementing
			customer.setId(++customersCount);
		}
		customers.add(customer);
		return customer;
		
	}
	
	//Delete Customer by ID
	public Customer deleteCustomer(int id) {
		Iterator<Customer> iterator = customers.iterator();
		while(iterator.hasNext()) {
			Customer customer = iterator.next();
			if(customer.getId() == id) {
				iterator.remove();
				return customer;
			}
			
			
		}
		
		return null;
	}
	
	
	

}
