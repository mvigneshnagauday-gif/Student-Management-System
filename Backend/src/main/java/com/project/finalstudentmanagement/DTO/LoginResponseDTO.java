package com.project.finalstudentmanagement.DTO;


import com.project.finalstudentmanagement.Student.Role;


public class LoginResponseDTO {
    private Integer id;
    private String username;
    private Role role;
    private String message;

    public LoginResponseDTO(Integer id, String username, Role role, String message) {
        this.id = id;
        this.username = username;
        this.role = role;
        this.message = message;
        
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}