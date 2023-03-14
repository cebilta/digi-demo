package com.example.testdemo.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testdemo.model.Employee;
import com.example.testdemo.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepo repo;
	
	public Employee saveEmployee(Employee employee) {
		return repo.save(employee);
	}
	
	public boolean isDOBMatches(String dateString, Long ppo_num) {
		try {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				try {
						LocalDate date = LocalDate.parse(dateString, formatter);
						try {
							
							Employee employee = repo.findById(ppo_num).get();
							System.out.println("send" + date + "in db : "+ employee.getDob());
							return date.isEqual(employee.getDob());
						}
						catch(NoSuchElementException e) {
							System.out.println("No such person exist");
							System.out.println(e);
							return false;
						}
					}
				catch(DateTimeParseException e) {
					System.out.println("date time parse error occured");
					return false;
				}
				
		}
		catch(IllegalArgumentException e) {
			System.out.println("illegal arguments present");
			return false;
		}
	}

}
