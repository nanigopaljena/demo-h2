package com.demo.h2.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.h2.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

	Employee findByEmployeeName(String employeeName);

}
