package com.demo.h2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "student_id", length = 255, nullable = false, unique = true)
	public String studentId;

	@Column(name = "student_name")
	private String studentName;

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Student() {
		super();
	}

	public Student(String studentName) {
		super();
		this.studentName = studentName;
	}

	public Student(String studentId, String studentName) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
	}

}
