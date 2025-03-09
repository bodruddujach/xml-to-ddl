package com.assignment.dd.exception;

public class ForeignKeyReferenceException extends RuntimeException {
	public ForeignKeyReferenceException(String message) {
		super(message);
	}
}
