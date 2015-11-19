package com.dghuang.student_manager.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.dghuang.student_manager.dto.UniversityDTO;

@Entity
public class University {
	
	@Id
	@Column(updatable=false)
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid", strategy="uuid2")
	private String id;
	
	@Column(nullable=false, unique=true)
	private String name;
	
	@ElementCollection
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Student> students = new ArrayList<Student>();
	
	public University() {
	}
	
	public University(UniversityDTO universityDTO){
		this.id = universityDTO.getId();
		this.name = universityDTO.getName();
	}
	
	public boolean addStudent(Student student) {
		return students.add(student);
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

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
}