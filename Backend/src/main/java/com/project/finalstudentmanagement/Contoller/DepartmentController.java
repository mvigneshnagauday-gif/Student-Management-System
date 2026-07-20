package com.project.finalstudentmanagement.Contoller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import com.project.finalstudentmanagement.DTO.DepartmentRequestDTO;
import com.project.finalstudentmanagement.DTO.DepartmentResponseDTO;
import com.project.finalstudentmanagement.Service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
@CrossOrigin("*")
public class DepartmentController {

    private final DepartmentService service;

    @Autowired
    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @PostMapping("/addDepartment")
    public DepartmentResponseDTO addDepartment(@Valid @RequestBody DepartmentRequestDTO dto) {
        return service.addDepartment(dto);
    }

    @GetMapping
    public List<DepartmentResponseDTO> getAllDepartments() {
        return service.getAllDepartments();
    }

    @GetMapping("/{id}")
    public DepartmentResponseDTO getDepartmentById(@PathVariable Integer id) {
        return service.getDepartmentById(id);
    }

    @PutMapping("/{id}")
    public DepartmentResponseDTO updateDepartment(@PathVariable Integer id, @Valid @RequestBody DepartmentRequestDTO dto) {
        return service.updateDepartment(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Integer id) {
        service.deleteDepartment(id);
        return ResponseEntity.ok("Department deleted successfully");
    }

    @GetMapping("/search")
    public List<DepartmentResponseDTO> searchDepartment(@RequestParam String keyword) {
        return service.searchDepartment(keyword);
    }
}