package com.udpt.salaryService.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udpt.salaryService.models.Salary;
import com.udpt.salaryService.services.SalaryService;

@RestController
@RequestMapping(path = "/api/Salary")
public class SalaryController {
	
	@Autowired
	private SalaryService service;
	
	@PutMapping("/create/{employeeId}")
	Salary createOneSalary(@PathVariable int employeeId) {
		return service.createOneSalary(employeeId);
	}
	
	@PutMapping("/update/{employeeId}")
	Salary updateOneSalary(@PathVariable int employeeId) {
		return service.updateOneSalary(employeeId);
	}
	
	@GetMapping("/all")
	List<Salary> getAll() {
		return service.getAll();
	}
	
	@GetMapping("/current/{employeeId}")
	Salary showCurrentSalary(@PathVariable int employeeId) {
		return service.showOneCurrentSalary(employeeId);
	}
	
	@GetMapping("/all/{employeeId}")
	List<Salary> showAllSalary(@PathVariable int employeeId) {
		return service.showOneAllSalary(employeeId);
	}
}
