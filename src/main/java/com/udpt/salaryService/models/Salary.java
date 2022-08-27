package com.udpt.salaryService.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="[salary]")
public class Salary {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="[salary_id]")
	private int salaryId;
	
	@Column(name="[employee_id]")
	private int employeeId;
	
	@Column(name="[date]")
	private Date date;
	
	@Column(name="[money]")
	private double money;

	public Salary() {
		// TODO Auto-generated constructor stub
	}

	public Salary(int employeeId, Date date, double money) {
		this.employeeId = employeeId;
		this.date = date;
		this.money = money;
	}

	public int getSalaryId() {
		return salaryId;
	}

	public void setSalaryId(int salaryId) {
		this.salaryId = salaryId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}
	
	
	
}
