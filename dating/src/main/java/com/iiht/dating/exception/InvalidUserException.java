package com.iiht.dating.exception;

public class InvalidUserException extends RuntimeException {

	private static final long serialVersionUID = 8929095317953630546L;

	public InvalidUserException(String message) {
		super(message);
	}	
}