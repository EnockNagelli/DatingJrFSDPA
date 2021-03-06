package com.iiht.dating.model;

public class UserExceptionResponse {
	
	private String message;
	private long timeStamp;
	private int status;
	
	public UserExceptionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserExceptionResponse(String message, long timeStamp, int status) {
		super();
		this.message = message;
		this.timeStamp = timeStamp;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}