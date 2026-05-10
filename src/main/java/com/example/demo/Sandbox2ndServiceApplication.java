package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@PropertySource("classpath:common.properties")
@EnableScheduling
public class Sandbox2ndServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sandbox2ndServiceApplication.class, args);
	}
}
