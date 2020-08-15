package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler 
{
	@ExceptionHandler(value = {StudentNotFoundException.class})
	public ResponseEntity<ErrorResponse> handleStudentNotFoundException(StudentNotFoundException exception)
	{
		ErrorResponse errResp=new ErrorResponse("NOT_FOUND", "Student id:"+exception.getId()+" record not found");
		return new ResponseEntity<>(errResp,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = {RuntimeException.class})
	public ResponseEntity<ErrorResponse> handleGlobalException(RuntimeException exception)
	{
		ErrorResponse errResp=new ErrorResponse("PROCESSING_ERROR", "Processing error, please contact cust serv");
		return new ResponseEntity<>(errResp,HttpStatus.NOT_FOUND);
	}

}
