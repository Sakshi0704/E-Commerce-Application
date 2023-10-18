
package com.ecommerce.service.Imps;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.exception.DataAlreadyExitsException;
import com.ecommerce.model.Customer;
import com.ecommerce.repository.CustomerRepository;
import com.ecommerce.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepo;
	
	
	@Override
	public Customer registerCustomer(Customer customer) throws DataAlreadyExitsException {

		Optional<Customer> opt = customerRepo.findByEmail(customer.getEmail());
		
		if(opt.isPresent()) {
			throw new DataAlreadyExitsException("With this email "+customer.getEmail()+" "+customer.getRole()+" already exits");
		}
		
		customerRepo.save(customer);
		
		return customer;
	}
	
}
