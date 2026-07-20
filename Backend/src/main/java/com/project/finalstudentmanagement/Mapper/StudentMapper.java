package com.project.finalstudentmanagement.Mapper;

import com.project.finalstudentmanagement.DTO.StudentRequestDTO;
import com.project.finalstudentmanagement.DTO.StudentResponseDTO;
import com.project.finalstudentmanagement.Student.ModelStudent;

public class StudentMapper {

    public static ModelStudent toEntity(StudentRequestDTO dto) {
        ModelStudent student = new ModelStudent();
        student.setFullName(dto.getFullName());
        student.setEmail(dto.getEmail());
        student.setPhone(dto.getPhone());
        student.setDepartment(dto.getDepartment());
        student.setDob(dto.getDob());
        student.setAddress(dto.getAddress());
        student.setGender(dto.getGender());
        return student;
    }

    public static StudentResponseDTO toResponseDTO(ModelStudent student) {
        StudentResponseDTO dto = new StudentResponseDTO();
        dto.setId(student.getId());
        dto.setFullName(student.getFullName());
        dto.setEmail(student.getEmail());
        dto.setPhone(student.getPhone());
        dto.setDepartment(student.getDepartment());
        dto.setDob(student.getDob());
        dto.setAddress(student.getAddress());
        dto.setGender(student.getGender());
        return dto;
    }
}