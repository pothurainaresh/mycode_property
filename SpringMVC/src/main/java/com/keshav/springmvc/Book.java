package com.keshav.springmvc;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class Book 
{
	private int id;
	private String name;
	private String author;
	private BigDecimal price;
	
	
	public Book(int id, String name, String author, BigDecimal price) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
	}



	public Book() {
	}

	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public BigDecimal getPrice() {
		return price;
	}



	public void setPrice(BigDecimal price) {
		this.price = price;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
}
