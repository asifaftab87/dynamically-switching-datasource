package org.two.data.source.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.two.data.source.entity.Employee;
import org.two.data.source.repository.EmployeeRepository;

@Service
public class EmployeeService {

	Logger log = LoggerFactory.getLogger(EmployeeService.class);
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getEmployees() {
		
		return employeeRepository.findAll();
	}
}