package com.udpt.salaryService.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.udpt.salaryService.models.Check;

@Service
public interface CheckService {

	Check create(Check check);
	
	Check update(Check check);
	
	int deleteTempo(int checkId);
	
	int restore(int checkId);
	
	int delete(int checkId);
	
	List<Check> getAll();
	
	List<Check> getOneAll(int employeeId);
	
	Optional<Check> getOne(int checkId);
	
	Check checkin(int employeeId);
	
	List<Check> getAllOfOne(int employeeId);
}
