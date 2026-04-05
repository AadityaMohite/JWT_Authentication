package com.Aadi.serviceimpl;

import org.springframework.beans.BeanUtils;

import com.Aadi.dto.EmployeeDto;
import com.Aadi.entity.Employee;
import com.Aadi.repo.EmployeeRepository;
import com.Aadi.service.EmployeeService;

public class EmployeeServiceIMpl implements EmployeeService {

	
	private final EmployeeRepository employeeRepository;
	
	
	public EmployeeServiceIMpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	
	
	
	  public EmployeeDto saveemployee(EmployeeDto employeeDto) {
		  
		  
		                     Employee employee = new Employee();
		                     
		                     BeanUtils.copyProperties(employeeDto, employee);
		                     
		                     
		         Employee employee2    =        employeeRepository.save(employee);
		         
		         BeanUtils.copyProperties(employee2, employeeDto);
		         
		         
				 return employeeDto;
		  
	  }
	
	
	
	
	
	
	
}
