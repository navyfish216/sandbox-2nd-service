package com.example.demo.second.service;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.example.demo.sahred.util.ProcessUtility;
import com.example.demo.second.web.response.SandBox2ndResponse;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SandBox2ndService {

	@Autowired
	private ProcessUtility processUtility;
	
	@Autowired
	private MessageSource messageSource;
	
	public String getString() throws Exception {
		
		log.info(messageSource.getMessage("sandbox.service.log.start", new String[]{processUtility.getProccessName()}, Locale.getDefault()));
		var ret = "This is 2nd service.";
		log.info(messageSource.getMessage("sandbox.service.log.end", new String[]{processUtility.getProccessName()}, Locale.getDefault()));
		
		return ret;
	}
	
	public SandBox2ndResponse callApi() throws Exception {
		
		log.info(messageSource.getMessage("sandbox.service.log.start", new String[]{processUtility.getProccessName()}, Locale.getDefault()));
		
		RestClient restClient = RestClient.create();
		
		ResponseEntity<SandBox2ndResponse> result = restClient.get() 
				  .uri("http://localhost:18081") 
				  .retrieve() 
				  .toEntity(SandBox2ndResponse.class);
		
		log.info(messageSource.getMessage("sandbox.service.log.end", new String[]{processUtility.getProccessName()}, Locale.getDefault()));
		
		return result.getBody();
	}
}
