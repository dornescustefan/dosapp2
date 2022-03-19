package com.project3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project3.model.Employee;

@Repository("employeeRepository")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
@Modifying
@Transactional
@Query
("update com.project3.model.Employee e set e.name = ?1, e.address=?2, e.email=?3, e.photo=?4 where e.id = ?5")
int updateEmployee(String name, String address, String email, String photo, int id);

List<Employee> findEmployeeByName(String searchedEmployee);

}
