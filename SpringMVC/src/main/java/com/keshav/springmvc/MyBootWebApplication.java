package com.keshav.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
@SpringBootApplication(scanBasePackages= {"com.keshav.springmvc"})
@EnableWebMvc
public class MyBootWebApplication extends SpringBootServletInitializer 
{
   public static void main(String[] args) {
	SpringApplication.run(MyBootWebApplication.class, args);
}
   protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
   {
	   return application.sources(MyBootWebApplication.class);
   }
}
