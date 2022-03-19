package com.project3.service;

import java.util.List;

import com.project3.model.Employee;

public interface EmployeeService {
	
	void deleteEmployee(int id);
	
	List<Employee> findAllEmployees();
    
	Employee findEmployeeById(int id);
    
	Employee save(Employee employee);
	
	void updateEmployee(Employee employee);
	
	List<Employee> findEmployeeByName(String searchedEmployee);
}

