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


	ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
	List<Country> countries = (List<Country>) context.getBean("countryList");
	
//	public Country getCountryIndia() {
//
//		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
//		Country country = context.getBean("in", Country.class);
//		return country;
//	}

	public List<Country> getAllCountries() {


		return countries;
	}

	public Country getCountry(String code) throws CountryNotFoundException {

		String bean = code.toLowerCase();

		for (Country country : countries) {
			if (country.getCode().equalsIgnoreCase(bean)) {
				return context.getBean(bean, Country.class);
			}

		}
		throw new CountryNotFoundException();

	}
	public void addCountry(Country country) {
		boolean bool = true;
		for (Country cntry : countries) {
			if (cntry.getCode().equals(country.getCode())) {
				bool = false;
				break;
			}
		}
		if (bool) {
			countries.add(country);
		} else {
			System.out.println("Already exist");
		}
	}
}
