//service that contains business logic for university manipulations

package com.dghuang.student_manager.service;

import java.util.List;

import com.dghuang.student_manager.dto.UniversityDTO;

public interface UniversityService {

	List<UniversityDTO> getUniversities();
	
	UniversityDTO createUniversity(UniversityDTO university);
	
	UniversityDTO modifyUniversity(UniversityDTO university);
	
	boolean deleteUniversity(String id);
	
}