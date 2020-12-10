package com.demo.h2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.demo.h2.entity.Employee;
import com.demo.h2.service.EmployeeService;

@RestController
@RequestMapping("/")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("employee")
	public List<Employee> listAllAtudent() {
		return employeeService.getAllEmployee();
	}

	@PostMapping("employee")
	public Employee addEmployee(@RequestBody Employee employee) {
		try {
			return employeeService.saveEmployee(employee);
		} catch (ResponseStatusException exc) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Hello Gopal ", exc);
		}

	}

	@PutMapping("employee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}

	@DeleteMapping("employee")
	public Employee deleteEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}

}
