package com.abhishek.batchprocessing.exception;

public class RecordNotDeletedException extends SbAppException{

	public RecordNotDeletedException() {
		super();
	}

	public RecordNotDeletedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public RecordNotDeletedException(String message, Throwable cause) {
		super(message, cause);
	}

	public RecordNotDeletedException(String message) {
		super(message);
	}

	public RecordNotDeletedException(Throwable cause) {
		super(cause);
	}
	
	

}
