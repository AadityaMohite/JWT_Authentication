package com.Aadi.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class EmployeeDto {

private String name;
	
	@Column(unique = true)
	private String email;
	
	
	private String gender;
	
	private Double Salary;
	
	
}
