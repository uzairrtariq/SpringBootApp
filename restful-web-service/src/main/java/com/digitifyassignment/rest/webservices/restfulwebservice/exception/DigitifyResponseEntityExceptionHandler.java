package com.digitifyassignment.rest.webservices.restfulwebservice.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.digitifyassignment.rest.webservices.restfulwebservice.Customer.UserNotFoundException;

// to be applicable across all controller use @Controlleradvice
@ControllerAdvice
@RestController
public class DigitifyResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	//Basically overiding ResponseEntityExceptionHandler and some of its methods
	//Using the below methods I can throw exception in my own format
	// In order to maintain a default standard
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions (Exception ex, WebRequest request){
		
		ExceptionResponse exceptionResponse = 
				new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundExceptions (Exception ex, WebRequest request){
		
		ExceptionResponse exceptionResponse = 
				new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse exceptionResponse = 
				new ExceptionResponse(new Date(), "Validation Failed", ex.getBindingResult().getAllErrors().toString());
		
		return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
		

	}

}
