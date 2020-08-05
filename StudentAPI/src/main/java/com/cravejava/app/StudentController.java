package com.cravejava.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myapp")
public class StudentController 
{
	@GetMapping("/welcome")
	public String welcome()
	{
		return "Welcome to my student application";
	}
	
	@RequestMapping(method = RequestMethod.GET,path = "/getBurger")
	public String getMyBurger()
	{
		return "get my burger";
	}

}
