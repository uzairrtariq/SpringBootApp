package com.digitifyassignment.rest.webservices.restfulwebservice.Customer;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Corder {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String description;
	
	//ignore customer to avoid revursive loop -> imp
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Customer customer;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	@Override
	public String toString() {
		return "Order [id=" + id + ", description=" + description + "]";
	}
	
	
	

}
