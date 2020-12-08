package com.manipal.demo.exception;

public class ExceptionResponse {
	private String message;
	
	public ExceptionResponse() {}

	public ExceptionResponse(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
