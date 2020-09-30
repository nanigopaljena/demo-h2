package com.demo.h2.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.h2.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
