package com.abhishek.batchprocessing.exception;

public class SbAppException extends Exception {

	public SbAppException() {
		super();
	}

	public SbAppException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public SbAppException(String message, Throwable cause) {
		super(message, cause);
	}

	public SbAppException(String message) {
		super(message);
	}

	public SbAppException(Throwable cause) {
		super(cause);
	}
	
	

}
