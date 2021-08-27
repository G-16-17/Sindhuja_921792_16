package com.cognizant.springlearn;

import org.slf4j.LoggerFactory;

import org.slf4j.Logger;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Country {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	String code;
	String name;
	public Country() {

		LOGGER.debug("Inside Country Constructor.");
		
	}
}
