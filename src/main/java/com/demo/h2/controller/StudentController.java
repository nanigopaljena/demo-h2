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

	@GetMapping("get-all-blocking")
	public List<Student> listAllStudent() {
		long start = System.currentTimeMillis();
		List<Student> resp = studentService.getAllStudent();
		long end = System.currentTimeMillis();  // End time measurement
		System.out.println("blocking processing took: " + (end - start) + "ms");
		return resp;

	}

}
