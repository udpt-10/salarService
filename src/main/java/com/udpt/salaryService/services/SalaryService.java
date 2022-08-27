package com.udpt.salaryService.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.udpt.salaryService.models.Salary;

@Service
public interface SalaryService {

	Salary createOneSalary(int employeeId);
	
	List<Salary> showOneAllSalary(int employeeId);
	
	List<Salary> showAllCurrentSalary();
	
	Salary showOneCurrentSalary(int employeeId);
	
	List<Salary> createAllSalary();
	
	List<Salary> getAll();
	
	Salary updateOneSalary(int employeeId);
	
}
