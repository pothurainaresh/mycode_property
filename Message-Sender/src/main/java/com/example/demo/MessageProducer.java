package com.example.demo;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer 
{
	@Autowired
	RabbitTemplate template;
	
	public void sendMessage(String exchange,String routingKey,String message)
	{
		template.convertAndSend(exchange, routingKey, message);
	}

}
