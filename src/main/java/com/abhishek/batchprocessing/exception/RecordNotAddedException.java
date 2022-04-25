package com.abhishek.batchprocessing.exception;

public class RecordNotAddedException extends SbAppException{

	public RecordNotAddedException() {
		super();
	}

	public RecordNotAddedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public RecordNotAddedException(String message, Throwable cause) {
		super(message, cause);
	}

	public RecordNotAddedException(String message) {
		super(message);
	}

	public RecordNotAddedException(Throwable cause) {
		super(cause);
	}
	
	

}
