package com.assignment.dd.exception.handler;

import java.time.LocalDateTime;

public class ErrorResponse {
	private String message;
	private String details;
	private int statusCode;
	private String timestamp;

	public ErrorResponse(String message, String details, int statusCode) {
		this.message = message;
		this.details = details;
		this.statusCode = statusCode;
		this.timestamp = LocalDateTime.now().toString();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
}
