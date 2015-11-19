package com.dghuang.student_manager.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dghuang.student_manager.dto.StudentDTO;
import com.dghuang.student_manager.entity.Student;
import com.dghuang.student_manager.service.StudentService;

@RestController
@RequestMapping(value=MappingValues.STUDENTS)
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public ResponseEntity getStudents() {
		List<Student> students = studentService.getStudents();
		return new ResponseEntity<>(students, HttpStatus.OK);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity createStudent(@RequestParam String universityName, @RequestBody StudentDTO studentDTO) {
		StudentDTO student = studentService.createStudent(universityName, studentDTO);
		if (student == null) {
			return new ResponseEntity<>(student, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(student, HttpStatus.OK);
	}
	
}