//Controller that handles requests to student endpoint

package com.dghuang.student_manager.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dghuang.student_manager.dto.StudentDTO;
import com.dghuang.student_manager.dto.UniversityDTO;
import com.dghuang.student_manager.entity.Student;
import com.dghuang.student_manager.service.StudentService;

@RestController
@RequestMapping(value=MappingValues.STUDENTS)
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity getStudents() {
		List<Student> students = studentService.getStudents();
		return new ResponseEntity<>(students, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity createStudent(@RequestBody StudentDTO studentDTO) {
		StudentDTO student = studentService.createStudent(studentDTO);
		if (student == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(student, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity editStudent(@RequestBody StudentDTO studentDTO) {
		StudentDTO student = studentService.editStudent(studentDTO);
		if (student == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(student, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	public ResponseEntity deleteStudent(@RequestBody @Valid StudentDTO student) {
		boolean deleted = studentService.deleteStudent(student.getId());
		if (deleted == true) {
			return new ResponseEntity(HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
}