//Java object that can be used to interact directly with the university table in postgreSQL

package com.dghuang.student_manager.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.dghuang.student_manager.entity.University;

public interface UniversityRepository extends PagingAndSortingRepository<University, String> {

	University findByName(String name);
	
}