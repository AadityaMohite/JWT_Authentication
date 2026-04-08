package com.Aadi.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.Aadi.dto.EmployeeDto;
import com.Aadi.entity.Employee;
import com.Aadi.exception.EmployeeNotfoundException;
import com.Aadi.repo.EmployeeRepository;
import com.Aadi.service.EmployeeService;

@Service
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




	  @Override
	  public List<Employee> getEmployees() {
		  
		  
		  
		               List<Employee>   employees   =     employeeRepository.findAll();
		  
		  
		  if(employees.isEmpty()) {
			  throw new EmployeeNotfoundException("Employee is Not found");
		  }
		  else {
		return employees;
	
		  }  
		  
		  
		  
	  }




	




	  @Override
	  public Employee getEmployeeByID(Integer id) {
		
		  
		  Optional<Employee> op = employeeRepository.findById(id);
		  
		  if(op.isPresent()) {
			  Employee employee =  op.get();
			  
			  
			  return employee;
		  }
		  else {
			  throw new EmployeeNotfoundException("Employee is not found at this id");
		  }
		  
		
	  }




	 
	
	
	
	
	
	
	
}
