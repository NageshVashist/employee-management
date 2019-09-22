package com.societegenerale.exception;

import java.util.Date;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class ExceptionResponse{
	private Date timestamp;
	private String error;
	private String details;

	public ExceptionResponse(Date timestamp, String error, String details) {
		super();
		this.timestamp = timestamp;
		this.error = error;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getError() {
		return error;
	}

	public String getDetails() {
		return details;
	}

}
