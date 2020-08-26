package com.exercise.stategies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class StategiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(StategiesApplication.class, args);
	}

}
