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
	
	public StudentDTO createStudent(StudentDTO studentDTO) {
		University university = universityRepository.findByName(studentDTO.getUniversity());
		if (university == null) {
			return null;
		}
		Student student = new Student(studentDTO);
		student.setUniversity(university);
		student = studentRepository.save(student);
		return new StudentDTO(student);
	}
	
	public StudentDTO editStudent(StudentDTO studentDTO) {
		University university = universityRepository.findByName(studentDTO.getUniversity());
		Student student = studentRepository.findOne(studentDTO.getId());
		if (student == null || university == null) {
			return null;
		}
		student.update(studentDTO);
		student = studentRepository.save(student);
		return new StudentDTO(student);
	}
	
	public boolean deleteStudent(String id) {
		Student student = studentRepository.findOne(id);
		if (student != null) {
			studentRepository.delete(id);
			return true;
		}
		return false;
	}
	
}
