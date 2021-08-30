package com.cognizant.springrest.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cognizant.springrest.model.Country;
import com.cognizant.springrest.service.exception.CountryNotFoundException;

@Service
public class CountryService {

	public Country getCountryIndia() {

		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = context.getBean("in", Country.class);
		return country;
	}

	public List<Country> getAllCountries() {

		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		List<Country> countries = (List<Country>) context.getBean("countryList");

		return countries;
	}

	public Country getCountry(String code) throws CountryNotFoundException {

		String bean = code.toLowerCase();

		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		List<Country> countries = (List<Country>) context.getBean("countryList");
		for (Country country : countries) {
			if (country.getCode().equalsIgnoreCase(bean)) {
				return context.getBean(bean, Country.class);
			}

		}
		throw new CountryNotFoundException();

	}
}
