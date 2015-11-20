package com.dghuang.student_manager.service;

import java.util.List;

import com.dghuang.student_manager.dto.StudentDTO;
import com.dghuang.student_manager.entity.Student;

public interface StudentService {
	
	List<Student> getStudents();
	
	StudentDTO createStudent(StudentDTO studentDTO);
	
	StudentDTO editStudent(StudentDTO studentDTO);
	
	boolean deleteStudent(String id);
}
