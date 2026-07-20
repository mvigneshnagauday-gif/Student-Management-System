package com.project.finalstudentmanagement.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.finalstudentmanagement.Student.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    List<Department> findByNameContainingIgnoreCaseOrCodeContainingIgnoreCase(String name, String code);
}