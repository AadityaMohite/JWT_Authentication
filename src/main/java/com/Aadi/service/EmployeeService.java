package com.Aadi.service;

import java.util.List;
import java.util.stream.Gatherer.Integrator;

import com.Aadi.dto.EmployeeDto;
import com.Aadi.entity.Employee;



public interface EmployeeService {

	
	
	EmployeeDto saveemployee(EmployeeDto employeeDto);
	
	
  List<Employee> getEmployees();
	
  
 Employee getEmployeeByID(Integer id);
 
 
  EmployeeDto updateemployee(Integer Id, EmployeeDto employeeDto);
	
   String deleteemployee(Integer id);
}
