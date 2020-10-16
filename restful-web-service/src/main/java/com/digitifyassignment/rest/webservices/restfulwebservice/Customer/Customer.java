package com.digitifyassignment.rest.webservices.restfulwebservice.Customer;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class Customer {
	
	private Integer id;
	
	//validation for name
	@Size(min = 2, message = "Name should have at least two characters.")
	private String name;
	
	//Validation for Birthdate
	@Past
	private Date birthDate;
	
	
	//Constructor for the bean
	public Customer(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	
	
	
	
	

}
