package com.demo.h2.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.h2.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, String> {

	Department findByDepartmentName(String string);

	Department findByDepartmentId(String string);

}
