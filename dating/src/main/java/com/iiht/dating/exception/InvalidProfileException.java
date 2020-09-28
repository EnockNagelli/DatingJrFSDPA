package com.iiht.dating.exception;

public class InvalidProfileException extends RuntimeException {

	private static final long serialVersionUID = -8025749728305919444L;

	public InvalidProfileException(String message) {
		super(message);
	}
}
