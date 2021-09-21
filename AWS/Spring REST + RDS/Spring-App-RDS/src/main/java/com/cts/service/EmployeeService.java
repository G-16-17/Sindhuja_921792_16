package com.cts.service;

import java.util.List;

import com.cts.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployee();

	String addEmployee(Employee employee);
}
