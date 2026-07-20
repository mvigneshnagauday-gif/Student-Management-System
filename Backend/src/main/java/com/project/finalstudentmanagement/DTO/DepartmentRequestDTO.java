package com.project.finalstudentmanagement.DTO;

import jakarta.validation.constraints.NotBlank;
public class DepartmentRequestDTO {

    @NotBlank(message = "Department name cannot be empty")
    private String name;

    @NotBlank(message = "Department code cannot be empty")
    private String code;

   

	@NotBlank(message = "Description cannot be empty")
    private String description;
	 public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}
}