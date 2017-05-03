package com.rxqp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.rxqp.mapper")
public class SpringbootApplication {

	public static void main(String[] args) {
//		SpringApplication.run(SpringbootApplication.class, args);
		SpringApplication app = new SpringApplication(SpringbootApplication.class);
		app.setWebEnvironment(false);
		app.run(args);
	}
}
