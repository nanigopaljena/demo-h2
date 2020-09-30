package com.demo.h2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.h2.entity.Student;
import com.demo.h2.service.StudentService;

@RestController
@RequestMapping("/")
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping("get-all-student")
	public List<Student> listAllAtudent() {
		return studentService.getAllStudent();
	}

}
