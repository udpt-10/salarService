package com.udpt.salaryService.models;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="[check]")
public class Check {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="[check_id]")
	private int checkId;
	
	@Column(name="[employee_id]")
	private int employeeId;
	
	@Column(name="[checkin_time]")
	private Time checkinTime;
	
	@Column(name="[checkout_time]")
	private Time checkoutTime;
	
	@Column(name="[working_time]")
	private float workingTime;
	
	@Column(name="[date]")
	private Date date;
	
	@Column(name="[is_active]")
	private int isActive;
	
	public Check() {}

	public Check(int employeeId, Time checkinTime, Time checkoutTime, float workingTime, Date date) {
		this.employeeId = employeeId;
		this.checkinTime = checkinTime;
		this.checkoutTime = checkoutTime;
		this.workingTime = workingTime;
		this.date = date;
		this.isActive = 1;
	}

	public int getCheckId() {
		return checkId;
	}

	public void setCheckId(int checkId) {
		this.checkId = checkId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public Time getCheckinTime() {
		return checkinTime;
	}

	public void setCheckinTime(Time checkinTime) {
		this.checkinTime = checkinTime;
	}

	public Time getCheckoutTime() {
		return checkoutTime;
	}

	public void setCheckoutTime(Time checkoutTime) {
		this.checkoutTime = checkoutTime;
	}

	public float getWorkingTime() {
		return workingTime;
	}

	public void setWorkingTime(float workingTime) {
		this.workingTime = workingTime;
	}
 
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	
}
