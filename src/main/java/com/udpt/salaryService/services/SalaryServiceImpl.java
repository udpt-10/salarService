package com.udpt.salaryService.services;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udpt.salaryService.models.Check;
import com.udpt.salaryService.models.Salary;
import com.udpt.salaryService.repositories.CheckRepository;
import com.udpt.salaryService.repositories.SalaryRepository;

@Service
public class SalaryServiceImpl implements SalaryService {

	@Autowired
	private CheckRepository checkRepository;
	
	@Autowired
	private SalaryRepository salaryRepository;
	
	@Override
	public Salary createOneSalary(int employeeId) {
		// TODO Auto-generated method stub
		Date currentDate = Date.valueOf(LocalDate.now());
		List<Salary> listSalary = salaryRepository.findByEmployeeId(employeeId);
		if(listSalary.size() > 0) {
			Salary salary = listSalary.get(listSalary.size()-1);
			List<Check> listCheck = checkRepository.findAllByEmployeeId(employeeId);
			double money = 0;
			double base = 100;
			int i = 1;
			while (listCheck.size()>=i && listCheck.get(listCheck.size()-i).getDate().after(salary.getDate())) {
				money += listCheck.get(listCheck.size()-i).getWorkingTime() * base;
				i++;
			}
			Salary newSalary = new Salary(employeeId, currentDate, money);
			return salaryRepository.save(newSalary);
		}
		List<Check> listCheck = checkRepository.findAllByEmployeeId(employeeId);
		double money = 0;
		double base = 100;
		int i = 1;
		while (listCheck.size()>=i) {
			money += listCheck.get(listCheck.size()-i).getWorkingTime() * base; 
			i++;
		}
		Salary newSalary = new Salary(employeeId, currentDate, money);
		return salaryRepository.save(newSalary);
	}
	
	@Override
	public Salary updateOneSalary(int employeeId) {
		// TODO Auto-generated method stub
		Date currentDate = Date.valueOf(LocalDate.now());
		List<Salary> listSalary = salaryRepository.findByEmployeeId(employeeId);
		if(listSalary.size() == 0)
			return this.createOneSalary(employeeId);
		Salary salary = listSalary.get(listSalary.size()-1);
		if(listSalary.size() > 1) {
			List<Check> listCheck = checkRepository.findAllByEmployeeId(employeeId);
			double money = 0;
			double base = 100;
			int i = 1;
			while (listCheck.size()>=i && listCheck.get(listCheck.size()-i).getDate().after(listSalary.get(listSalary.size()-2).getDate())) {
				money += listCheck.get(listCheck.size()-i).getWorkingTime() * base;
				i++;
			}
			salary.setDate(currentDate);
			salary.setMoney(money);
			return salaryRepository.save(salary);
		}
		List<Check> listCheck = checkRepository.findAllByEmployeeId(employeeId);
		double money = 0;
		double base = 100;
		int i = 1;
		while (listCheck.size()>=i) {
			money += listCheck.get(listCheck.size()-i).getWorkingTime() * base; 
			i++;
		}
		salary.setDate(currentDate);
		salary.setMoney(money);
		return salaryRepository.save(salary);
	}

	@Override
	public List<Salary> showOneAllSalary(int employeeId) {
		// TODO Auto-generated method stub
		return salaryRepository.findByEmployeeId(employeeId);
	}

	@Override
	public List<Salary> showAllCurrentSalary() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Salary showOneCurrentSalary(int employeeId) {
		// TODO Auto-generated method stub
		if(salaryRepository.findByEmployeeId(employeeId).size()>0 && salaryRepository.findByEmployeeId(employeeId).get(salaryRepository.findByEmployeeId(employeeId).size()-1).getDate().equals(Date.valueOf(LocalDate.now())))
			return salaryRepository.findByEmployeeId(employeeId).get(salaryRepository.findByEmployeeId(employeeId).size()-1);
		return null;
	}

	@Override
	public List<Salary> createAllSalary() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Salary> getAll() {
		return salaryRepository.findAll();
	}

}
