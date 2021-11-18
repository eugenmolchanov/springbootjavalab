package com.itechart.javalab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JavalabApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavalabApplication.class, args);
	}

}
