package com.demo.h2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.h2.entity.Student;
import com.demo.h2.repo.StudentRepository;

@Component
public class DatabaseLoader implements CommandLineRunner {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	public DatabaseLoader(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		saveStudent();

	}

	private void saveStudent() {
		studentRepository.save(new Student("Gopal"));
		studentRepository.save(new Student("Bishesh"));
		studentRepository.save(new Student("Vinay"));
		studentRepository.save(new Student("Vinay"));

	}

}
