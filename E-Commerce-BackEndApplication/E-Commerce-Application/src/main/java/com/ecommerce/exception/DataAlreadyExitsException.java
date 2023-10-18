package com.ecommerce.exception;

public class DataAlreadyExitsException extends RuntimeException{

	public DataAlreadyExitsException() {
		super();
	}
	
	public DataAlreadyExitsException(String message) {
		super(message);
	}
	
}
