package com.udpt.salaryService.database;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.udpt.salaryService.models.Check;
import com.udpt.salaryService.models.Salary;
import com.udpt.salaryService.repositories.CheckRepository;
import com.udpt.salaryService.repositories.SalaryRepository;

@Configuration
public class Database {
	
	private static final Logger logger = LoggerFactory.getLogger(Database.class);
	
	@Bean
	CommandLineRunner initDatabase1(CheckRepository checkRepository) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				/*
				 * Check checkA = new Check(1, Time.valueOf(LocalTime.now()),
				 * Time.valueOf(LocalTime.now()), 8, Date.valueOf(LocalDate.now())); Check
				 * checkB = new Check(2, Time.valueOf("8:00:00"), Time.valueOf("8:00:00"), 8,
				 * Date.valueOf("2022-08-26"));
				 * logger.info("insert data: "+checkRepository.save(checkA));
				 * logger.info("insert data: "+checkRepository.save(checkB));
				 */
			}
		};
	}
	
	@Bean
	CommandLineRunner initDatabase2(SalaryRepository salaryRepository) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				/*
				 * Salary salary = new Salary(1,Date.valueOf("2022-08-25"),1000);
				 * logger.info("insert data: "+salaryRepository.save(salary));
				 */
			}
		};
	}
}
