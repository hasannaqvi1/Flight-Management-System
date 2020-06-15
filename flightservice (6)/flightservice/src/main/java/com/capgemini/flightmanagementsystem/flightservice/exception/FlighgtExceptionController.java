package com.capgemini.flightmanagementsystem.flightservice.exception;

import java.util.HashMap;

import java.util.Map;

import javax.validation.ConstraintViolationException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class FlighgtExceptionController {
	@ExceptionHandler(FlightNotFoundException.class)
	public String handleException(FlightNotFoundException e) {
		
		return e.getMessage();
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public Map<String, String> handleConstraintViolation(ConstraintViolationException ex) {
	    Map<String, String> errors = new HashMap<>();
	     
	    ex.getConstraintViolations().forEach(cv -> {
	        errors.put("message", cv.getMessage());
	        errors.put("path", (cv.getPropertyPath()).toString());
	    }); 
	    return errors;
	}
//	public ResponseEntity<ErrorMessage> handleException(FlightNotFoundException e) {
//		ErrorMessage error=new ErrorMessage();
//		error.setStatusCode(HttpStatus.BAD_GATEWAY.value());
//		error.setErrorMessage(e.getMessage());
//		return new ResponseEntity<>(error,HttpStatus.OK);
//				
//	}
//
//	public ResponseEntity<ErrorMessage> genericException(Exception e) {
//		ErrorMessage error=new ErrorMessage();
//		error.setStatusCode(HttpStatus.BAD_REQUEST.value());
//		error.setErrorMessage(e.getMessage());
//		return new ResponseEntity<>(error,HttpStatus.OK);
//	}
//	
}
