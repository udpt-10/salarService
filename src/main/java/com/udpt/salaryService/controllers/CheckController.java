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

import com.udpt.salaryService.models.Check;
import com.udpt.salaryService.services.CheckService;

@RestController
@RequestMapping(path = "/api/Check")
public class CheckController {
	
	@Autowired
	private CheckService service;
	
	@GetMapping("/all")
	List<Check> getAllChecks() {
		return service.getAll();
	}
	
	@PutMapping("/checkin/{id}")
	Check checkin(@PathVariable int id) {
		return service.checkin(id);
	}
	
	@PostMapping("update")
	Check updateCheck(@RequestBody Check check) {
		return service.update(check);
	}
	
	@GetMapping("/all/{id}")
	List<Check> getAllOfOne(@PathVariable int id) {
		return service.getOneAll(id);
	}
}
