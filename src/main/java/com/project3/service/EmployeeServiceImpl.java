package com.project3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project3.model.Employee;
import com.project3.repository.EmployeeRepository;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	
		@Autowired
		private EmployeeRepository employeeRepository;
		
		@Transactional
		public Employee save(Employee employee) {
			return employeeRepository.save(employee);
		}
		
		public List<Employee> findAllEmployees(){
			return employeeRepository.findAll();
		}
		
		public void deleteEmployee(int id) {
			employeeRepository.deleteById(id);
		}

		public Employee findEmployeeById(int id) {
		    Employee employee = new Employee();
			employee = employeeRepository.getOne(id);
			return employee;
		}

		public void updateEmployee(Employee employee) {
			 String name = employee.getName();
			 String address = employee.getAddress();
			 String email = employee.getEmail();
			 String photo = employee.getPhoto();
			 int id = employee.getId();
			 employeeRepository.updateEmployee(name, address, email, photo, id);
				
		}

		public List<Employee> findEmployeeByName(String searchedEmployee) {
			// TODO Auto-generated method stub
			return employeeRepository.findEmployeeByName(searchedEmployee);
		}

}
