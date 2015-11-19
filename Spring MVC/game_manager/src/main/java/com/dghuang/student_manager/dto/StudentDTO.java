package com.dghuang.student_manager.dto;

import com.dghuang.student_manager.entity.Student;
import com.dghuang.student_manager.entity.University;

public class StudentDTO {
	
	private String id;
	
	private String name;
	
	private double gradeAverage;
	
	private String university;
	
	public StudentDTO() {
		
	}

	public StudentDTO( Student student ) {
		this.id = student.getId();
		this.name = student.getName();
		this.gradeAverage = student.getGradeAverage();
		University university = student.getUniversity();
		if (university != null) {
			this.university = university.getName();
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getGradeAverage() {
		return gradeAverage;
	}

	public void setGradeAverage(double gradeAverage) {
		this.gradeAverage = gradeAverage;
	}
	
	public String getUniversity() {
		return university;
	}
	
	public void setUniversity(String university) {
		this.university = university;
	}
}
