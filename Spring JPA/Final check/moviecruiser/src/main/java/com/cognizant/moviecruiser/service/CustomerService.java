package com.cognizant.moviecruiser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.model.Customer;
import com.cognizant.moviecruiser.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository custRepository;

	public List<Customer> getAllCustomer() {
		return custRepository.findAll();
	}

	public void addCustomer(String name) {
		custRepository.save(new Customer(name));
	}

	public Customer getCustomerById(int id) {
		return custRepository.findById(id).get();
	}
}
