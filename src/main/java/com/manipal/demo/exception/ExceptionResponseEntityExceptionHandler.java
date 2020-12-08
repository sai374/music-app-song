package com.manipal.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(AdminNotFoundException.class)
	public ResponseEntity<ExceptionResponse> adminNotFound(AdminNotFoundException exception) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage());
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SongNotFoundException.class)
	public ResponseEntity<ExceptionResponse> songNotFound(SongNotFoundException exception) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage());
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ExceptionResponse> userNotFound(UserNotFoundException exception) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage());
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
}
