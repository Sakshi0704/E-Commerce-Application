package com.ecommerce.service;

import java.io.IOException;
import java.util.List;

import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.model.Customer;
import com.ecommerce.model.Image;

public interface CustomerService {

	public Customer registerCustomer(Customer customer) throws ResourceNotFoundException; // user & admin 
	
	public Customer getCustomerByEmail(String email) throws ResourceNotFoundException;  // user & admin
	
	public Customer searchByContact(String contact); // admin
	
	public Customer updateCustomerDetails(String email, Customer customer)
			throws ResourceNotFoundException;          // user & admin
	
	public Customer deleteCustomerAccount(String email) throws ResourceNotFoundException; // admin
	
	public List<Customer> searchByfirstName(String firstName); // admin
	
	public List<Customer> getAllCustomerDetails(Integer page, Integer size, String sortDirection, String sortBy); // admin

	public List<Customer> searchBylastName(String lastName); // admin

	public List<Customer> searchByFirstAndLastName(String firstName, String lastName); // admin
	
	public Customer updateCustomerImage(String email, Image image)
			throws ResourceNotFoundException, IOException;   // user & admin

	public String deleteCustomerImage(String fileName) throws IOException; // user & admin
	
}
