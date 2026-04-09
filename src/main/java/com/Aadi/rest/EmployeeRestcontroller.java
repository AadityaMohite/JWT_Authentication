package com.Aadi.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Aadi.dto.EmployeeDto;
import com.Aadi.entity.Employee;
import com.Aadi.service.EmployeeService;

@RestController
public class EmployeeRestcontroller {

	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/save-employee")
	public ResponseEntity<EmployeeDto> SaveEmployee(@RequestBody EmployeeDto employeeDto) {
		
		
		    
	EmployeeDto  employeeDto2 =	employeeService.saveemployee(employeeDto);
		
		
		
		
		return new ResponseEntity<EmployeeDto>(employeeDto2,HttpStatus.OK);
		
		
	}
	
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getemployees()
	{
		
		
		          List<Employee>  employees  =       employeeService.getEmployees();
		          
		          
		          
		          
		          
		          return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
		
	}
	
	@GetMapping("/getemployee/{id}")
	public ResponseEntity<Employee> getEmployees(@PathVariable Integer id){
		
	Employee employee =	employeeService.getEmployeeByID(id);
		
		return new  ResponseEntity<Employee>(employee,HttpStatus.OK);
	}
	
	@PostMapping("/update-employee/{id}")
	public ResponseEntity<EmployeeDto> updateemployees(@PathVariable Integer id,@RequestBody EmployeeDto employeeDto){
		
		EmployeeDto employeeDto2  =    employeeService.updateemployee(id, employeeDto);
		
		
		return new ResponseEntity<EmployeeDto>(employeeDto2,HttpStatus.OK);
		
		
	}
	
	
	
}
