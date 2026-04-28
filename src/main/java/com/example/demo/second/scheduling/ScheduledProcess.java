package com.example.demo.second.scheduling;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import com.example.demo.sahred.util.ProcessUtility;
import com.example.demo.second.web.response.SandBox2ndResponse;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ScheduledProcess {

	@Autowired
	private ProcessUtility processUtility;
	
	@Autowired
	private MessageSource messageSource;
	
    @Scheduled(fixedRate = 1, timeUnit = TimeUnit.MINUTES)
    public void fixedRate_withTimeUnit() throws Exception {
		
    	log.info(messageSource.getMessage("sandbox.process.log.start", new String[]{processUtility.getProccessName()}, Locale.getDefault()));
		
		RestClient restClient = RestClient.create();
		
		restClient.get() 
				  .uri("http://localhost:18082/2nd") 
				  .retrieve() 
				  .toEntity(SandBox2ndResponse.class);
		
		log.info(messageSource.getMessage("sandbox.process.log.end", new String[]{processUtility.getProccessName()}, Locale.getDefault()));
    }
}
