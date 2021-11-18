package com.itechart.javalab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class JavalabApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavalabApplication.class, args);
	}

}
