package com.project.finalstudentmanagement.Contoller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.project.finalstudentmanagement.Repository.StudentRepository;
import com.project.finalstudentmanagement.Repository.DepartmentRepository;
import com.project.finalstudentmanagement.Repository.FacultyRepository;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin("*")
public class DashboardController {

    private final StudentRepository studentRepo;
    private final DepartmentRepository departmentRepo;
    private final FacultyRepository facultyRepo;

    @Autowired
    public DashboardController(StudentRepository studentRepo, DepartmentRepository departmentRepo, FacultyRepository facultyRepo) {
        this.studentRepo = studentRepo;
        this.departmentRepo = departmentRepo;
        this.facultyRepo = facultyRepo;
    }

    @GetMapping("/summary")
    public Map<String, Long> getSummary() {
        Map<String, Long> summary = new HashMap<>();
        summary.put("totalStudents", studentRepo.count());
        summary.put("totalDepartments", departmentRepo.count());
        summary.put("totalFaculty", facultyRepo.count());
        return summary;
    }
}