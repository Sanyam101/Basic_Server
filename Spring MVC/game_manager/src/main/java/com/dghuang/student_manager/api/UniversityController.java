package com.dghuang.student_manager.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dghuang.student_manager.dto.UniversityDTO;
import com.dghuang.student_manager.service.UniversityService;

@RestController
@RequestMapping(value=MappingValues.UNIVERSITIES)
public class UniversityController {

	@Autowired
	UniversityService universityService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public ResponseEntity<List<UniversityDTO>> getUniversities() {
		List<UniversityDTO> universities = universityService.getUniversities();
		if (universities == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(universities, HttpStatus.OK);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<UniversityDTO> createUniversity(@RequestBody UniversityDTO university) {
		UniversityDTO universityDTO = universityService.createUniversity(university);
		if (universityDTO != null) {
			return new ResponseEntity<>(universityDTO, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	
}
