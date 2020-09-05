package com.example.demo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MessageConsumer 
{
	@RabbitListener(queues = "SNGQ")
	public void receiver(String messageReceived)
	{
		System.out.println("------Message reveived to User1(SNGQ):"+messageReceived);
	}
}
