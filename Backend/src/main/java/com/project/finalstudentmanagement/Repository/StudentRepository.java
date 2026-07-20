package com.project.finalstudentmanagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.finalstudentmanagement.Student.ModelStudent;

@Repository
public interface StudentRepository extends JpaRepository<ModelStudent, Integer> {
	List<ModelStudent> findByFullNameContainingIgnoreCaseOrEmailContainingIgnoreCase(String keyword, String keyword2);
}
