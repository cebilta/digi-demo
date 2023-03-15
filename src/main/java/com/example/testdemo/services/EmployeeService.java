package com.example.testdemo.services;

import com.example.testdemo.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	boolean  isDOBMatches(String dateString, Long ppo_num);
	Employee findEmployeebyId(Long ppo_number);
}
