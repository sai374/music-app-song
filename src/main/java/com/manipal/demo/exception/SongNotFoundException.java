package com.manipal.demo.exception;

public class SongNotFoundException extends Exception {
	
	public SongNotFoundException() {}
	
	public SongNotFoundException(String message) {
		super(message);
	}
}
