package com.udpt.salaryService.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udpt.salaryService.models.Salary;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Integer> {

	List<Salary> findByEmployeeId(int employeeId);
}
