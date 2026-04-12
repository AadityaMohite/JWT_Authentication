package com.Aadi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Aadi.entity.Employee;
import java.util.List;


public interface EmployeeRepository  extends JpaRepository<Employee, Integer>{
  
	
	List<Employee> findByName(String name);
	
	List<Employee> findBySalary(Double salary);
	
          List<Employee> findByEmail(String email);
    List<Employee> findByGender(String gender);      
}