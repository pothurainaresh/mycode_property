package com.example.demo;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RabbitMqConfig 
{
	//Create Exchange
	@Bean
	public Exchange exchange()
	{
		return ExchangeBuilder.topicExchange("TOPIC_EXCHANGE").build();
	}
	
	//Create Queues
	@Bean
	public Queue sportsQueue()
	{
		return QueueBuilder.durable("SNGQ").build();
	}
	
	@Bean
	public Queue hollywoodQueue()
	{
		return QueueBuilder.durable("HFGQ").build();
	}
	
	@Bean
	public Queue bollywoodQueue()
	{
		return QueueBuilder.durable("BFGQ").build();
	}
	
	//Binding queues with exchange
	
	
	@Bean
	public Binding bindExchangeSNGQ(Queue sportsQueue,TopicExchange exchange)
	{
		return BindingBuilder.bind(sportsQueue).to(exchange).with("S.N.GQ.RK");
	}
	
	
	
	@Bean
	public Binding bindExchangeHFGQ(Queue hollywoodQueue,TopicExchange exchange)
	{
		return BindingBuilder.bind(hollywoodQueue).to(exchange).with("*.F.GQ.RK");
	}
	
	@Bean
	public Binding bindExchangeBFGQ(Queue bollywoodQueue,TopicExchange exchange)
	{
		return BindingBuilder.bind(bollywoodQueue).to(exchange).with("*.F.*.RK");
	}
	
	
}
