package com.dghuang.student_manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dghuang.student_manager.dto.StudentDTO;
import com.dghuang.student_manager.entity.Student;
import com.dghuang.student_manager.entity.University;
import com.dghuang.student_manager.repository.StudentRepository;
import com.dghuang.student_manager.repository.UniversityRepository;
import com.google.common.collect.Lists;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	UniversityRepository universityRepository;
	
	public List<Student> getStudents() {
		List<Student> students = Lists.newArrayList(studentRepository.findAll());
		return students;
	}
	
	public StudentDTO createStudent(String universityName, StudentDTO studentDTO) {
		University university = universityRepository.findByName(universityName);
		if (university == null) {
			return null;
		}
		Student student = new Student(studentDTO);
		student.setUniversity(university);
		student = studentRepository.save(student);
		return new StudentDTO(student);
	}
	
}
