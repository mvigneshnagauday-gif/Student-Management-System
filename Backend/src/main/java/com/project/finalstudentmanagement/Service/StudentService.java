package com.project.finalstudentmanagement.Service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.finalstudentmanagement.DTO.StudentRequestDTO;
import com.project.finalstudentmanagement.DTO.StudentResponseDTO;
import com.project.finalstudentmanagement.Mapper.StudentMapper;
import com.project.finalstudentmanagement.Repository.StudentRepository;
import com.project.finalstudentmanagement.Student.ModelStudent;

@Service
public class StudentService {
    private final StudentRepository repo;

    @Autowired
    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public StudentResponseDTO addStudent(StudentRequestDTO dto) {
        ModelStudent student = StudentMapper.toEntity(dto);
        ModelStudent saved = repo.save(student);
        return StudentMapper.toResponseDTO(saved);
    }

    public String deleteStudent(Integer id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Student not found");
        }
        repo.deleteById(id);
        return "Student deleted successfully";
    }

    public List<StudentResponseDTO> searchStudent(String keyword) {
        List<ModelStudent> students =
                repo.findByFullNameContainingIgnoreCaseOrEmailContainingIgnoreCase(keyword, keyword);
        if (students.isEmpty()) {
            throw new RuntimeException("Student not found");
        }
        return students.stream()
                .map(StudentMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public StudentResponseDTO updateStudent(Integer id, StudentRequestDTO dto) {
        ModelStudent existingStudent = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        existingStudent.setFullName(dto.getFullName());
        existingStudent.setEmail(dto.getEmail());
        existingStudent.setPhone(dto.getPhone());
        existingStudent.setDepartment(dto.getDepartment());
        existingStudent.setDob(dto.getDob());
        existingStudent.setAddress(dto.getAddress());
        existingStudent.setGender(dto.getGender());
        return StudentMapper.toResponseDTO(repo.save(existingStudent));
    }

    public List<StudentResponseDTO> getallStudents() {
        return repo.findAll().stream()
                .map(StudentMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public StudentResponseDTO getStudentById(Integer id) {
        ModelStudent student = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        return StudentMapper.toResponseDTO(student);
    }
}