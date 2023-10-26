package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.service.CustomerService;

@RestController
@RequestMapping("/buymart/customers")
public class CustomerController {

	@Autowired
	public CustomerService customerService;
	

	public ResponseEntity<Customer> getCustomerById(){
		
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}
	
	

	
	public ResponseEntity<Customer> getCustomerByEmail(){
		
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}
}
