package com.project.exception;

public class SongNotFoundException extends Exception {
	
	public SongNotFoundException() {}
	
	public SongNotFoundException(String message) {
		super(message);
	}
}
