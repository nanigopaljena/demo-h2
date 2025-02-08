package com.demo.h2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.h2.entity.Student;
import com.demo.h2.repo.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	public List<Student> getAllStudent() {
		List<Student> list = studentRepository.findAll();
		list.forEach(data->{
					data.setStudentName(data.getStudentName().toUpperCase());
				});
		return list;
	}

}
