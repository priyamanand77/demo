package com.test.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

	
	List<Student> findByGender(String gender);
	List<Student> findByName(String name);
	
}
