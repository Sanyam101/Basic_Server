package com.dghuang.student_manager.dto;

import com.dghuang.student_manager.entity.University;

public class UniversityDTO {
	
	String id;
	
	String name;
	
	public UniversityDTO() {
	}
	
	public UniversityDTO(University university) {
		this.id = university.getId();
		this.name = university.getName();
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
	
	
}
