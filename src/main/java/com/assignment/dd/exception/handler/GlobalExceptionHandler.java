package com.assignment.dd.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.assignment.dd.exception.ForeignKeyReferenceException;
import com.assignment.dd.exception.GeneralSQLExecutionException;
import com.assignment.dd.exception.TableAlreadyExistsException;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(TableAlreadyExistsException.class)
	public ResponseEntity<ErrorResponse> handleTableAlreadyExistsException(TableAlreadyExistsException ex) {
		ErrorResponse errorResponse = new ErrorResponse("The table already exists in the database.", ex.getMessage(),
				HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ForeignKeyReferenceException.class)
	public ResponseEntity<ErrorResponse> handleForeignKeyReferenceException(ForeignKeyReferenceException ex) {
		ErrorResponse errorResponse = new ErrorResponse("Foreign key reference error.", ex.getMessage(),
				HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(GeneralSQLExecutionException.class)
	public ResponseEntity<ErrorResponse> handleGeneralSQLException(GeneralSQLExecutionException ex) {
		ErrorResponse errorResponse = new ErrorResponse("An error occurred while processing the table.",
				ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex) {
		ErrorResponse errorResponse = new ErrorResponse("Something went wrong! Please try again later.",
				"Unexpected error occurred.", HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
