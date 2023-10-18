package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Customer;
import com.ecommerce.payload.AppConstants;
import com.ecommerce.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/buymart/auth")
public class AuthenticationController {

	@Autowired
	public CustomerService customerService;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
/*
	{
		  "userId": 0,
		  "firstName": "Sakshi",
		  "lastName": "Choudhary",
		  "contact": "9958090196",
		  "email": "sakshi@gmail.com",
		  "password": "12345",
		  "image": {
		    "imageName": "string",
		    "imageUrl": "string"
		  },
		  "dateOfBirth": "2002-02-05",
		  "accountCreateDate": "2023-10-17T22:43:48.550Z",
		  "accountUpdatedDate": "2023-10-17T22:43:48.550Z",
		  "address": {
		    "addressId": 0,
		    "addressLine1": "D/O Kavita Choudhary",
		    "addressLine2": "",
		    "buildingName": "Surya Appartment",
		    "landMark": "Ramind Showroom",
		    "city": "Noida",
		    "state": "UP",
		    "country": "Indian",
		    "pincode": "201301",
		    "addressCreateDate": "2023-10-17T22:43:48.550Z",
		    "addressUpdateDate": "2023-10-17T22:43:48.550Z"
		  }
		}
	*/

	@PostMapping("/customers/signup") 
	public ResponseEntity<Customer> registerUserHandler(@Valid @RequestBody Customer customer) {

		customer.setRole(AppConstants.ROLE_USER);
		customer.setPassword(passwordEncoder.encode(customer.getPassword()));
		Customer saveCustomer = customerService.registerCustomer(customer);
		return new ResponseEntity<Customer>(saveCustomer, HttpStatus.CREATED);
	}

	
	@PostMapping("/admins/signup")
	public ResponseEntity<Customer> registerAdminHandler(@Valid @RequestBody Customer customer) {

		customer.setRole(AppConstants.ROLE_ADMIN);
		
		customer.setPassword(passwordEncoder.encode(customer.getPassword()));

		Customer saveAdmin = customerService.registerCustomer(customer);

		return new ResponseEntity<Customer>(saveAdmin, HttpStatus.CREATED);

	}
	
	@PostMapping("/customers/signin")
	public ResponseEntity<Customer> loginUserHandler(Authentication auth){
		
		Customer customer = customerService.getCustomerByEmail(auth.getName());
		
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);			
	}
	
	@PostMapping("/admins/signin")
	public ResponseEntity<Customer> loginAdminHandler(Authentication auth){
		
		Customer customer = customerService.getCustomerByEmail(auth.getName());
		
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);			
	}
	
	
	
	

}
