package com.digitifyassignment.rest.webservices.restfulwebservice.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorderRepo extends JpaRepository<Corder, Integer> {

}
