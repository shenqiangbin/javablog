package com.sqber.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BlogApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(BlogApplication.class, args);
	}
	
	@Override  
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {  
                      return application.sources(BlogApplication.class);  
    } 

}
