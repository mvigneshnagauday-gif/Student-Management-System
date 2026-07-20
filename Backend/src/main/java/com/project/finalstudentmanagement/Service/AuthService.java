package com.project.finalstudentmanagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.finalstudentmanagement.DTO.LoginRequestDTO;
import com.project.finalstudentmanagement.DTO.LoginResponseDTO;
import com.project.finalstudentmanagement.DTO.RegisterRequestDTO;
import com.project.finalstudentmanagement.Exception.InvalidCredentialsException;
import com.project.finalstudentmanagement.Repository.UserRepository;
import com.project.finalstudentmanagement.Student.User;

@Service
public class AuthService {

    private final UserRepository repo;

    @Autowired
    public AuthService(UserRepository repo) {
        this.repo = repo;
    }

    public LoginResponseDTO login(LoginRequestDTO dto) {
        User user = repo.findByUsername(dto.getUsername())
                .orElseThrow(() -> new InvalidCredentialsException("Invalid username or password"));

        if (!user.getPassword().equals(dto.getPassword())) {
            throw new InvalidCredentialsException("Invalid username or password");
        }

        return new LoginResponseDTO(user.getId(), user.getUsername(), user.getRole(), "Login successful");
    }

    public LoginResponseDTO register(RegisterRequestDTO dto) {
        if (repo.findByUsername(dto.getUsername()).isPresent()) {
            throw new InvalidCredentialsException("Username already exists");
        }

        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());

        User saved = repo.save(user);
        return new LoginResponseDTO(saved.getId(), saved.getUsername(), saved.getRole(), "Registration successful");
    }
}