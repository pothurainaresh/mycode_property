package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController 
{
	@Autowired
	MessageProducer producer;
	
	@GetMapping("/")
	public String sendMessage()
	{
		
		producer.sendMessage("TOPIC_EXCHANGE", "CRAVEJAVA.F.GQ.RK", "TOPIC message received");
		return "Message sent successfuly";
	}

}
