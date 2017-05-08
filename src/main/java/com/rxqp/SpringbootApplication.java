package com.rxqp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.rxqp.mapper")
public class SpringbootApplication extends SpringBootServletInitializer{

	 protected SpringApplicationBuilder configure(
	            SpringApplicationBuilder application) {
	        return application.sources(SpringbootApplication.class);
	    }
	 
	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
//		SpringApplication app = new SpringApplication(SpringbootApplication.class);
//		app.setWebEnvironment(false);
//		app.run(args);
	}
}
