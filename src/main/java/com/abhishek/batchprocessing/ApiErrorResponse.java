package com.abhishek.batchprocessing;

public class ApiErrorResponse {

	private String message;

	private Object cause;

	private Object exceptionMessage;

	private boolean success;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getCause() {
		return cause;
	}

	public void setCause(Object cause) {
		this.cause = cause;
	}

	public Object getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(Object exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	

}
