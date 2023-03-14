package com.example.testdemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.testdemo.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{

}
