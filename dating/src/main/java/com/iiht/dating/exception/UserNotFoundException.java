package com.iiht.dating.exception;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 6012620085753915327L;

	public UserNotFoundException(String message) {
		super(message);
	}
}