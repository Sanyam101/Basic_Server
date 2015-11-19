package com.dghuang.student_manager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.dghuang.student_manager.dto.StudentDTO;

@Entity
public class Student {

	@Id
	@Column(updatable=false)
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid", strategy="uuid2")
	private String id;

	private double gradeAverage;

	private String name;
	
	@ManyToOne
	@JoinColumn(nullable=false) 
	private University university;
	
	/*
	 * Constructors
	 */
	public Student() {
	}
	
	public Student( StudentDTO studentDTO ) {
		this.id = studentDTO.getId();
		this.name = studentDTO.getName();
		this.gradeAverage = studentDTO.getGradeAverage();
	}
	/*
	 * Vanilla getters and setters
	 */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getGradeAverage() {
		return gradeAverage;
	}

	public void setGradeAverage(double gradeAverage) {
		this.gradeAverage = gradeAverage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public University getUniversity() {
		return university;
	}
	
	public void setUniversity(University university) {
		this.university = university;
	}
}
