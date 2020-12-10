package com.demo.h2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.h2.entity.Department;
import com.demo.h2.repo.DepartmentRepository;
import com.demo.h2.repo.EmployeeRepository;

@Component
public class DatabaseLoader implements CommandLineRunner {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	public DatabaseLoader(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
		this.employeeRepository = employeeRepository;
		this.departmentRepository = departmentRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		saveDept();

	}

	private void saveDept() {
		departmentRepository.save(new Department("Marketing"));
		departmentRepository.save(new Department("Development"));
		departmentRepository.save(new Department("Testing"));
		departmentRepository.save(new Department("HR"));
	}

}
