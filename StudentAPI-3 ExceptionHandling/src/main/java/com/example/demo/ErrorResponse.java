package com.example.demo;

import java.sql.Timestamp;
import java.util.Date;

public class ErrorResponse 
{

	private Timestamp timestamp;
	private String errorCode;
	private String errorMessage;
	public ErrorResponse(String errorCode, String errorMessage) {
		this.timestamp=new Timestamp(new Date().getTime());
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}



}
