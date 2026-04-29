package com.example.demo.second.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@Data
public class Sandox2ndConfiguration {

	@Value("${server.port:8080}")
	private Integer selfServerPort;
	
}
