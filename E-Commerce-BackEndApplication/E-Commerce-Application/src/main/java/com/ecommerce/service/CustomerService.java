package com.ecommerce.service;

import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.model.Customer;

public interface CustomerService {

	Customer registerCustomer(Customer customer) throws ResourceNotFoundException;
	
}
