package com.example.demo.second.service;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.example.demo.sahred.enumeration.ServiceNameCatalog;
import com.example.demo.sahred.util.ProcessUtility;
import com.example.demo.sahred.util.ServiceUrlUtility;
import com.example.demo.second.web.response.Sandbox2ndResponse;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Sandbox2ndService {

	@Autowired
	private RestClient restClient;

	@Autowired
	private ServiceUrlUtility serviceUrlUtility;

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

	public Sandbox2ndResponse callApi() throws Exception {

		log.info(messageSource.getMessage("sandbox.service.log.start", new String[]{processUtility.getProccessName()}, Locale.getDefault()));

		String url = serviceUrlUtility.getUrl(ServiceNameCatalog.SANDBOX_SERVICE) + "/sleep";
		ResponseEntity<Sandbox2ndResponse> result = restClient.get().uri(url).retrieve().toEntity(Sandbox2ndResponse.class);

		log.info(messageSource.getMessage("sandbox.service.log.end", new String[]{processUtility.getProccessName()}, Locale.getDefault()));

		return result.getBody();
	}
}
