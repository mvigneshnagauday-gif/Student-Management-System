package com.project.finalstudentmanagement.Mapper;

import com.project.finalstudentmanagement.DTO.DepartmentRequestDTO;
import com.project.finalstudentmanagement.DTO.DepartmentResponseDTO;
import com.project.finalstudentmanagement.Student.Department;

public class DepartmentMapper {

    public static Department toEntity(DepartmentRequestDTO dto) {
        Department department = new Department();
        department.setName(dto.getName());
        department.setCode(dto.getCode());
        department.setDescription(dto.getDescription());
        return department;
    }

    public static DepartmentResponseDTO toResponseDTO(Department department) {
        DepartmentResponseDTO dto = new DepartmentResponseDTO();
        dto.setId(department.getId());
        dto.setName(department.getName());
        dto.setCode(department.getCode());
        dto.setDescription(department.getDescription());
        return dto;
    }
}