package com.example.demo.second.service;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.example.demo.sahred.util.ProcessUtility;

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
	
}
