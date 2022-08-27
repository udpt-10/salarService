package com.udpt.salaryService.services;

import java.sql.Date;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udpt.salaryService.models.Check;
import com.udpt.salaryService.repositories.CheckRepository;

@Service
public class CheckServiceImpl implements CheckService {

	@Autowired
	private CheckRepository checkRepository;
	
	@Override
	public Check create(Check check) {
		// TODO Auto-generated method stub
		Check newCheck = new Check(check.getEmployeeId(), check.getCheckinTime(), check.getCheckoutTime(), check.getWorkingTime(), check.getDate());
		return checkRepository.save(newCheck);
	}

	@Override
	public Check update(Check newCheck) {
		// TODO Auto-generated method stub
		if(checkRepository.existsById(newCheck.getCheckId())) {
			Check updateCheck = checkRepository.findById(newCheck.getCheckId()).get();
			updateCheck.setEmployeeId(newCheck.getEmployeeId());
			updateCheck.setCheckinTime(newCheck.getCheckinTime());
			updateCheck.setCheckoutTime(newCheck.getCheckoutTime());
			updateCheck.setWorkingTime(newCheck.getWorkingTime());
			updateCheck.setDate(newCheck.getDate());
			updateCheck.setIsActive(newCheck.getIsActive());
			return checkRepository.save(updateCheck);
		} else {
			return this.create(newCheck);
		}
	}

	@Override
	public int deleteTempo(int checkId) {
		// TODO Auto-generated method stub
		if(checkRepository.existsById(checkId))
		{
			Check updateCheck = checkRepository.findById(checkId).get();
			updateCheck.setIsActive(0);
			checkRepository.save(updateCheck);
		}
		return 0;
	}

	@Override
	public int restore(int checkId) {
		// TODO Auto-generated method stub
		if(checkRepository.existsById(checkId))
		{
			Check updateCheck = checkRepository.findById(checkId).get();
			updateCheck.setIsActive(1);
			checkRepository.save(updateCheck);
		}
		return 0;
	}

	@Override
	public int delete(int checkId) {
		// TODO Auto-generated method stub
		if(checkRepository.existsById(checkId))
		{
			checkRepository.deleteById(checkId);
		}
		return 0;
	}

	@Override
	public List<Check> getAll() {
		// TODO Auto-generated method stub
		return checkRepository.findAll();
	}

	@Override
	public Optional<Check> getOne(int checkId) {
		// TODO Auto-generated method stub
		return checkRepository.findById(checkId);
	}
	
	@Override
	public List<Check> getAllOfOne(int employeeId) {
		return checkRepository.findAllByEmployeeId(employeeId);
	}
	
	@Override
	public Check checkin(int employeeId) {
		Time checkTime = Time.valueOf(LocalTime.now());
		Date date = Date.valueOf(LocalDate.now());
		List<Check> listCheck = checkRepository.findAllByEmployeeId(employeeId);
		if(listCheck.size() > 0) {
			Check check = listCheck.get(listCheck.size()-1);
			if(check.getIsActive() == 1 && check.getDate().equals(date)) {
				Check updateCheck = check;
				
				float workingTime = Duration.between(updateCheck.getCheckinTime().toLocalTime(), checkTime.toLocalTime()).toHours(); // chua tinh gio lam
				updateCheck.setCheckoutTime(checkTime);
				updateCheck.setWorkingTime(workingTime);
				updateCheck.setIsActive(0);
				return checkRepository.save(updateCheck);
			}
		}
		Check newCheck = new Check(employeeId, checkTime, checkTime, 0, date);
		return checkRepository.save(newCheck);
	}
	
	@Override
	public List<Check> getOneAll(int employeeId) {
		return checkRepository.findAllByEmployeeId(employeeId);
	}
}
