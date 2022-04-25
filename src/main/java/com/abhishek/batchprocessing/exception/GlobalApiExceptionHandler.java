package com.abhishek.batchprocessing.exception;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.abhishek.batchprocessing.ApiErrorResponse;


@RestControllerAdvice
public class GlobalApiExceptionHandler {
	
	private ResponseEntity<Object> buildResponseEntity(ApiErrorResponse response,
			HttpStatus httpStatus) {
		
		return new ResponseEntity<>(response,httpStatus);
	}
	
	@ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ResponseEntity<Object> handleMethodArgumentTypeMismatchException(
			MethodArgumentTypeMismatchException ex, WebRequest request
			) {
		
		ApiErrorResponse response = new ApiErrorResponse();
		
		String message = ex.getName() + " should be of type "+ ex.getRequiredType().getName();
		
		response.setMessage(message);
		response.setCause(ex.getCause().getLocalizedMessage());
		response.setExceptionMessage(ex.getMessage());
		response.setSuccess(false);
		
		return buildResponseEntity(response, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(value = IOException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<Object> handleIOException(
			MethodArgumentTypeMismatchException ex, WebRequest request
			) {
		
		ApiErrorResponse response = new ApiErrorResponse();
		
		response.setMessage("I/O Error: Something went wrong.");
		response.setCause(ex.getCause().getLocalizedMessage());
		response.setExceptionMessage(ex.getMessage());
		response.setSuccess(false);
		
		return buildResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	
	@ExceptionHandler(value = Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<Object> handleAnyException(
				RecordNotDeletedException ex, WebRequest request
			) {
		
		ApiErrorResponse response = new ApiErrorResponse();
		
		response.setMessage("Something went wrong");
		response.setCause(ex.getCause().getLocalizedMessage());
		response.setExceptionMessage(ex.getMessage());
		response.setSuccess(false);
		
		return buildResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(value = RecordNotAddedException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ResponseEntity<Object> handleRecordNotAddedException(
				RecordNotDeletedException ex, WebRequest request
			) {
		
		ApiErrorResponse response = new ApiErrorResponse();
		
		response.setMessage("Record Not added");
		response.setCause(ex.getCause().getLocalizedMessage());
		response.setExceptionMessage(ex.getMessage());
		response.setSuccess(false);
		
		return buildResponseEntity(response, HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler(value = RecordNotDeletedException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ResponseEntity<Object> handleRecordNotDeletedException(
				RecordNotDeletedException ex, WebRequest request
			) {
		
		ApiErrorResponse response = new ApiErrorResponse();
		
		response.setMessage("Record Not Deleted");
		response.setCause(ex.getCause().getLocalizedMessage());
		response.setExceptionMessage(ex.getMessage());
		response.setSuccess(false);
		
		return buildResponseEntity(response, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(RecordNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ResponseEntity<Object> handleRecordNotFoundException(RecordNotFoundException ex, WebRequest request) {
		
		ApiErrorResponse response = new ApiErrorResponse();
		
		response.setMessage("Something went wrong !! Record not found.");
		response.setExceptionMessage(ex.getMessage());
		response.setSuccess(false);
		response.setCause(ex.getCause().getLocalizedMessage());
		
		return buildResponseEntity(response, HttpStatus.NOT_FOUND);
	}
	
 
	
}
