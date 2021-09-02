package com.cognizant.springrest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springrest.SpringRestApplication;

@RestController
public class HelloController {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringRestApplication.class);

	@GetMapping("/hello")
	public String sayHello() {
		LOGGER.info("Start");
		LOGGER.info("End");
		return "Hello World!!";

	}

}
