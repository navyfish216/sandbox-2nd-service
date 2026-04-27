package com.example.demo.second.web;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.sahred.util.ProcessUtility;
import com.example.demo.second.service.SandBox2ndService;
import com.example.demo.second.web.response.SandBox2ndResponse;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/2nd")
@Slf4j
public class SandBox2ndController {

	@Autowired
	private SandBox2ndService sandBox2ndService;
	
	@Autowired
	private ProcessUtility processUtility;

	@Autowired
	private MessageSource messageSource;
	
	@GetMapping(path = {"", "/"})
	public SandBox2ndResponse getString() throws Exception {
		
		log.info(messageSource.getMessage("sandbox.controller.log.start", new String[]{processUtility.getProccessName()}, Locale.getDefault()));
		var response = new SandBox2ndResponse(sandBox2ndService.getString());
		log.info(messageSource.getMessage("sandbox.controller.log.end", new String[]{processUtility.getProccessName()}, Locale.getDefault()));
		
		return response;
	}
	
}
