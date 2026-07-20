package com.project.finalstudentmanagement.Contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import com.project.finalstudentmanagement.DTO.LoginRequestDTO;
import com.project.finalstudentmanagement.DTO.LoginResponseDTO;
import com.project.finalstudentmanagement.DTO.RegisterRequestDTO;
import com.project.finalstudentmanagement.Service.AuthService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    private final AuthService service;

    @Autowired
    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public LoginResponseDTO login(@Valid @RequestBody LoginRequestDTO dto) {
        return service.login(dto);
    }

    @PostMapping("/register")
    public LoginResponseDTO register(@Valid @RequestBody RegisterRequestDTO dto) {
        return service.register(dto);
    }
}