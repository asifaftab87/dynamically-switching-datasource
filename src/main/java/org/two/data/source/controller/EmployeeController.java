package org.two.data.source.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.two.data.source.entity.Employee;
import org.two.data.source.service.EmployeeService;

@RestController
public class EmployeeController {

	Logger log = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping(value = "employee")
	public ResponseEntity<List<Employee>> getEmployees() {
		
		log.info("------------------------controller-------------------------");
		
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(employeeService.getEmployees());
	}
	
	@PostMapping(value = "employee")
	public ResponseEntity<List<Employee>> setEmployees() {
		
		log.info("------------------------controller-------------------------");
		
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(employeeService.getEmployees());
	}
}