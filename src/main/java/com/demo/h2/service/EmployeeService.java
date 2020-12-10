package com.demo.h2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.demo.h2.entity.Department;
import com.demo.h2.entity.Employee;
import com.demo.h2.repo.DepartmentRepository;
import com.demo.h2.repo.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	public Employee saveEmployee(Employee employee) {
		Department department = departmentRepository.findByDepartmentId(employee.getDepartment().getDepartmentId());
		Throwable exc = new Throwable();
		if (department != null) {
			Employee existingEmp = employeeRepository.findByEmployeeName(employee.getEmployeeName());
			if (existingEmp != null) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Foo Not Found", exc);
//				throw new ResourceNotFoundException("Employee already exist!");
			} else {
				employeeRepository.save(employee);
				employee.setDepartment(department);
				return employee;
			}
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Foo Not Found", exc);
//			throw new ResourceNotFoundException(
//					"Department Id " + employee.getDepartment().getDepartmentId() + " not found");
		}
	}

	public Employee updateEmployee(Employee employee) {
		Throwable exc = new Throwable();
		Department department = departmentRepository.findByDepartmentId(employee.getDepartment().getDepartmentId());
		if (department != null) {
			Employee existingEmp = employeeRepository.findByEmployeeName(employee.getEmployeeName());
			if (existingEmp != null) {
				employee.setEmployeeId(existingEmp.getEmployeeId());
				employeeRepository.save(employee);
				employee.setDepartment(department);
				return employee;
			} else {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Foo Not Found", exc);
//				throw new ResourceNotFoundException(
//						"Employee Id " + employee.getDepartment().getDepartmentId() + " not found");
			}
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Foo Not Found", exc);
//			throw new ResourceNotFoundException(
//					"Department Id " + employee.getDepartment().getDepartmentId() + " not found");
		}
	}

	public String deleteEmployee(Employee employee) {
		Throwable exc = new Throwable();
		try {
			employeeRepository.delete(employee);
			return "Delete Succusfully";
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Foo Not Found", exc);
		}

	}

}
