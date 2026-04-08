package com.Aadi.service;

import java.util.List;

import com.Aadi.dto.EmployeeDto;
import com.Aadi.entity.Employee;



public interface EmployeeService {

	
	
	EmployeeDto saveemployee(EmployeeDto employeeDto);
	
	
  List<Employee> getEmployees();
	
  
 Employee getEmployeeByID(Integer id);
	
	
}
