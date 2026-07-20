package com.project.finalstudentmanagement.Service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.finalstudentmanagement.DTO.DepartmentRequestDTO;
import com.project.finalstudentmanagement.DTO.DepartmentResponseDTO;
import com.project.finalstudentmanagement.Exception.DepartmentNotFoundException;
import com.project.finalstudentmanagement.Mapper.DepartmentMapper;
import com.project.finalstudentmanagement.Repository.DepartmentRepository;
import com.project.finalstudentmanagement.Student.Department;

@Service
public class DepartmentService {

    private final DepartmentRepository repo;

    @Autowired
    public DepartmentService(DepartmentRepository repo) {
        this.repo = repo;
    }

    public DepartmentResponseDTO addDepartment(DepartmentRequestDTO dto) {
        Department department = DepartmentMapper.toEntity(dto);
        Department saved = repo.save(department);
        return DepartmentMapper.toResponseDTO(saved);
    }

    public List<DepartmentResponseDTO> getAllDepartments() {
        return repo.findAll().stream()
                .map(DepartmentMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public DepartmentResponseDTO getDepartmentById(Integer id) {
        Department department = repo.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found with id: " + id));
        return DepartmentMapper.toResponseDTO(department);
    }

    public DepartmentResponseDTO updateDepartment(Integer id, DepartmentRequestDTO dto) {
        Department existing = repo.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found with id: " + id));
        existing.setName(dto.getName());
        existing.setCode(dto.getCode());
        existing.setDescription(dto.getDescription());
        return DepartmentMapper.toResponseDTO(repo.save(existing));
    }

    public String deleteDepartment(Integer id) {
        if (!repo.existsById(id)) {
            throw new DepartmentNotFoundException("Department not found with id: " + id);
        }
        repo.deleteById(id);
        return "Department deleted successfully";
    }

    public List<DepartmentResponseDTO> searchDepartment(String keyword) {
        List<Department> departments =
                repo.findByNameContainingIgnoreCaseOrCodeContainingIgnoreCase(keyword, keyword);
        if (departments.isEmpty()) {
            throw new DepartmentNotFoundException("No department found matching: " + keyword);
        }
        return departments.stream()
                .map(DepartmentMapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}