package com.udpt.salaryService.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udpt.salaryService.models.Check;

@Repository
public interface CheckRepository extends JpaRepository<Check, Integer> {

	List<Check> findAllByEmployeeId(int employeeId);

}
