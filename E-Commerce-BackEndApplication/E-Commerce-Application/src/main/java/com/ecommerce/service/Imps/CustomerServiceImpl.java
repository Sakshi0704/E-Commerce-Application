
package com.ecommerce.service.Imps;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.exception.DataAlreadyExitsException;

import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.model.Customer;
import com.ecommerce.model.Image;
import com.ecommerce.repository.CustomerRepository;
import com.ecommerce.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepo;
	
	
	@Override
	public Customer registerCustomer(Customer customer) throws ResourceNotFoundException {

		Optional<Customer> opt = customerRepo.findByEmail(customer.getEmail());
		
		if(opt.isPresent()) {
			throw new DataAlreadyExitsException("With this email "+customer.getEmail()+" "+customer.getRole()+" already exits");
		}
		
		customerRepo.save(customer);
		
		return customer;
	}


	@Override
	public Customer getCustomerByEmail(String email) throws ResourceNotFoundException {
		
		Optional<Customer> opt = customerRepo.findByEmail(email);
		
		if(!opt.isPresent()) {
			throw new ResourceNotFoundException("User doesn't found with email "+ email);
		}
		
		return opt.get();
	}


	@Override
	public Customer updateCustomerDetails(String email, Customer customer) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Optional<Customer> exitCustomer = customerRepo.findByEmail(email);
		
		
		return null;
	}


	@Override
	public Customer searchByContact(String contact) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Customer deleteCustomerAccount(String email) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Customer> searchByfirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Customer> getAllCustomerDetails(Integer page, Integer size, String sortDirection, String sortBy) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Customer> searchBylastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Customer> searchByFirstAndLastName(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Customer updateCustomerImage(String email, Image image) throws ResourceNotFoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String deleteCustomerImage(String fileName) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
