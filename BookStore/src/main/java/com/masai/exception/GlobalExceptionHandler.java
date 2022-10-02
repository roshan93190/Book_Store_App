package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

public class GlobalExceptionHandler {

	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<MyErrorDetails> myExceptionHandler(BookNotFoundException iae, WebRequest wr){
		System.out.println("Inside my exception handler");
		
		MyErrorDetails myErrorDetails=new MyErrorDetails();
		myErrorDetails.setTimeStamp(LocalDateTime.now());
		myErrorDetails.setMessage(iae.getMessage());
		myErrorDetails.setDescription(wr.getDescription(false));
		
		
		return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.BAD_REQUEST);
	}
	
	//to handle Not found exception
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> mynotFoundHandler(NoHandlerFoundException nfe,WebRequest req) {
	MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(), nfe.getMessage(), req.getDescription(false));
	return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}

}
