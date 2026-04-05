package com.Aadi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
 private	Integer id;
	
	
	private String name;
	
	@Column(unique = true)
	private String email;
	
	
	private String gender;
	
	private Double Salary;
	
	
	
		
}
