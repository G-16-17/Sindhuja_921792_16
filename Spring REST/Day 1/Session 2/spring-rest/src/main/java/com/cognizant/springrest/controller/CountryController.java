package com.cognizant.springrest.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springrest.SpringRestApplication;
import com.cognizant.springrest.model.Country;
import com.cognizant.springrest.service.CountryService;
import com.cognizant.springrest.service.exception.CountryNotFoundException;

@RestController
public class CountryController {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringRestApplication.class);

	@Autowired
	CountryService countryService;

	@RequestMapping("/country")
	public Country getCountryIndia() {
		LOGGER.info("Start");
		Country country = countryService.getCountryIndia();
		LOGGER.info("End");
		return country;
	}

	@GetMapping("/countries")
	public List<Country> getAllCountries() {
		LOGGER.info("Start");
		List<Country> countries = countryService.getAllCountries();
		LOGGER.info("End");
		return countries;
	}

	@GetMapping("/countries/{code}")
	public Country getCountry(@PathVariable String code) throws CountryNotFoundException {

		LOGGER.info("Start");
		LOGGER.info("End");
		Country country = countryService.getCountry(code);
		return country;
	}
}
