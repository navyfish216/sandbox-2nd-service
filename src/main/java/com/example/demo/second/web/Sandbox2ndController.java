package com.example.demo.second.web;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.sahred.util.ProcessUtility;
import com.example.demo.second.service.Sandbox2ndService;
import com.example.demo.second.web.response.Sandbox2ndResponse;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/2nd")
@Slf4j
public class Sandbox2ndController {

	@Autowired
	private Sandbox2ndService sandBox2ndService;

	@Autowired
	private ProcessUtility processUtility;

	@Autowired
	private MessageSource messageSource;

	@GetMapping(path = {"", "/"})
	public Sandbox2ndResponse getString() throws Exception {

		log.info(messageSource.getMessage("sandbox.controller.log.start", new String[]{processUtility.getProccessName()}, Locale.getDefault()));
		var response = new Sandbox2ndResponse(sandBox2ndService.getString());
		log.info(messageSource.getMessage("sandbox.controller.log.end", new String[]{processUtility.getProccessName()}, Locale.getDefault()));

		return response;
	}

	@GetMapping(path = {"/api", "/api/"})
	public Sandbox2ndResponse getApi() throws Exception {

		log.info(messageSource.getMessage("sandbox.controller.log.start", new String[]{processUtility.getProccessName()}, Locale.getDefault()));
		Sandbox2ndResponse response = sandBox2ndService.callApi();
		log.info(messageSource.getMessage("sandbox.controller.log.end", new String[]{processUtility.getProccessName()}, Locale.getDefault()));

		return response;
	}

}
