package com.example.demo;

import java.sql.Timestamp;
import java.util.Date;

public class StudentNotFoundException extends RuntimeException
{
	private int id;
	public StudentNotFoundException() {}
	public StudentNotFoundException(int id) {
		super();
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
