package com.Heliverse.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

//	Exception Handler for Exception class
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> exceptionClassHandler(Exception exception,WebRequest request){
		
		
		ErrorDetails details=new ErrorDetails(exception.getMessage(),request.getDescription(false),LocalDateTime.now());
		ResponseEntity<ErrorDetails> entity=new ResponseEntity<ErrorDetails>(details,HttpStatus.BAD_REQUEST); 
	   
		return entity;
	}
	
	


	
	
	
//	Exception Handler for No URI found or wrong uri
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorDetails> exceptionClassHandler(NoHandlerFoundException exception,WebRequest request){
		
		
		ErrorDetails details=new ErrorDetails(exception.getMessage(),request.getDescription(false),LocalDateTime.now());
		ResponseEntity<ErrorDetails> entity=new ResponseEntity<ErrorDetails>(details,HttpStatus.BAD_REQUEST); 
	   
		return entity;
	}


//	Exception handler for QuizException
	@ExceptionHandler(QuizException.class)
	public ResponseEntity<ErrorDetails> QuizExceptionHandler(QuizException exception,WebRequest request){
		
		
		ErrorDetails details=new ErrorDetails(exception.getMessage(),request.getDescription(false),LocalDateTime.now());
		ResponseEntity<ErrorDetails> entity=new ResponseEntity<ErrorDetails>(details,HttpStatus.BAD_REQUEST); 
	   
		return entity;
	}
	
	
	
}
