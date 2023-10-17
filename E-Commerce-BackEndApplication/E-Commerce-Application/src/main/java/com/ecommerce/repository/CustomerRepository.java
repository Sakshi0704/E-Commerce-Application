package com.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	public Optional<Customer> findByEmail(String email);
	
	public List<Customer> findByFirstName(String firstName);

	public List<Customer> findByLastName(String lastName);

	public Boolean existsByEmail(String email);

	public Boolean existsByContact(String contact);

	public List<Customer> findByFirstNameAndLastName(String firstName, String lastName);
	
}
