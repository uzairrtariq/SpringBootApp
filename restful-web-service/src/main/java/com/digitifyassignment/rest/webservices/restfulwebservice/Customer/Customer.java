package com.digitifyassignment.rest.webservices.restfulwebservice.Customer;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

//@ApiModel annotation for swagger documentation specification
@ApiModel(description = "Customer Dynamics")
@Entity
public class Customer {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	//validation for name
	//@ApiModelProperty if for specific variable description for Swagger
	@Size(min = 2, message = "Name should have at least two characters.")
	@ApiModelProperty(notes = "Name should have at least two characters.")
	private String name;
	
	//Validation for Birthdate
	//@ApiModelProperty if for specific variable description for Swagger
	@Past
	@ApiModelProperty(notes = "Birthday cannot be an upcoming date.")
	private Date birthDate;
	
	//Using List to store Orders
	//relationship is one to many; One customer -> many orders
	@OneToMany(mappedBy = "customer")
	private List<Corder> corders;
	
	
	protected Customer() {
		
	}
	
	
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
	

	public List<Corder> getOrders() {
		return corders;
	}


	public void setOrders(List<Corder> corders) {
		this.corders = corders;
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	
	
	
	
	

}
