package com.ecommerce.service;

import com.ecommerce.exception.DataAlreadyExitsException;
import com.ecommerce.model.Customer;

public interface CustomerService {

	public Customer registerCustomer(Customer customer) throws DataAlreadyExitsException;
	
}
