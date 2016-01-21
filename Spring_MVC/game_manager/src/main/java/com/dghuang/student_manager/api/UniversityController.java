//Controller that handles requests to university endpoint

package com.dghuang.student_manager.api;

import java.util.List;

import javax.validation.Valid;

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
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UniversityDTO>> getUniversities() {
		List<UniversityDTO> universities = universityService.getUniversities();
		if (universities == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(universities, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity createUniversity(@RequestBody @Valid UniversityDTO university) {
		UniversityDTO universityDTO = universityService.createUniversity(university);
		if (universityDTO != null) {
			return new ResponseEntity<>(universityDTO, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity modifyUniversity(@RequestBody @Valid UniversityDTO university) {
		UniversityDTO universityDTO = universityService.modifyUniversity(university);
		if (universityDTO != null) {
			return new ResponseEntity<>(universityDTO, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	public ResponseEntity deleteUniversity(@RequestBody @Valid UniversityDTO university) {
		boolean deleted = universityService.deleteUniversity(university.getId());
		if (deleted == true) {
			return new ResponseEntity(HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	
}
