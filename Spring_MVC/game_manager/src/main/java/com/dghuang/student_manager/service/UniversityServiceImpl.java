package com.dghuang.student_manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dghuang.student_manager.dto.UniversityDTO;
import com.dghuang.student_manager.entity.University;
import com.dghuang.student_manager.repository.UniversityRepository;
import com.google.common.collect.Lists;

@Service
public class UniversityServiceImpl implements UniversityService {
	
	@Autowired
	UniversityRepository universityRepository;

	public List<UniversityDTO> getUniversities() {
		List<University> found = Lists.newArrayList( universityRepository.findAll() );
		List<UniversityDTO> universities = Lists.newArrayList();
		for ( University university : found ) {
			UniversityDTO universityDTO = new UniversityDTO( university );
			universities.add( universityDTO );
		}
		return universities;
	}
	
	public UniversityDTO createUniversity(UniversityDTO universityDTO) {
		University university = universityRepository.findByName(universityDTO.getName());
		if (university == null) {
			university = new University(universityDTO);
			university.setId(null);
			return new UniversityDTO(universityRepository.save(university));
		}
		return null;
	}
	
	public UniversityDTO modifyUniversity(UniversityDTO universityDTO) {
		University university = universityRepository.findOne(universityDTO.getId());
		if (university != null) {
			university = new University(universityDTO);
			return new UniversityDTO(universityRepository.save(university));
		}
		return null;
	}
	
	public boolean deleteUniversity(String id) {
		University university = universityRepository.findOne(id);
		if (university != null) {
			universityRepository.delete(id);
			return true;
		}
		return false;
	}

}
