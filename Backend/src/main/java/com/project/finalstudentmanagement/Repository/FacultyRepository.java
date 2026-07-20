package com.project.finalstudentmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.finalstudentmanagement.Student.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
}