package com.project.finalstudentmanagement.Contoller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import com.project.finalstudentmanagement.DTO.StudentRequestDTO;
import com.project.finalstudentmanagement.DTO.StudentResponseDTO;
import com.project.finalstudentmanagement.Service.StudentService;

@RestController
@RequestMapping("/api/students")
@CrossOrigin("*")
public class StudentController {
    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/search")
    public List<StudentResponseDTO> getStudentByName(@RequestParam String name) {
        return service.searchStudent(name);
    }

    @GetMapping("/getallstudentDetails")
    public List<StudentResponseDTO> getAllStudents() {
        return service.getallStudents();
    }

    @GetMapping("/{id}")
    public StudentResponseDTO getStudentById(@PathVariable Integer id) {
        return service.getStudentById(id);
    }

    @PostMapping("/addStudent")
    public StudentResponseDTO saveStudent(@Valid @RequestBody StudentRequestDTO student) {
        return service.addStudent(student);
    }

    @PutMapping("/{id}")
    public StudentResponseDTO updateStudent(@PathVariable Integer id, @Valid @RequestBody StudentRequestDTO student) {
        return service.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer id) {
        service.deleteStudent(id);
        return ResponseEntity.ok("Student deleted successfully");
    }
}