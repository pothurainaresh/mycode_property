package com.keshav.springmvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController 
{
	@GetMapping("/showBooks")
	public String getBooks(HttpSession session)
	{
		List<Book> booksList= new ArrayList<Book>();
		Book b1=new Book(1, "HP1", "kesh",BigDecimal.valueOf(100.00));
		Book b2=new Book(2, "HP2", "kesh",BigDecimal.valueOf(200.00));
		Book b3=new Book(3, "HP3", "kesh",BigDecimal.valueOf(300.00));
		Book b4=new Book(4, "HP4", "kesh",BigDecimal.valueOf(400.00));
		booksList.add(b1);
		booksList.add(b2);
		booksList.add(b3);
		booksList.add(b4);
		session.setAttribute("mybooklist", booksList);
		return "showbooks";
	}

}
