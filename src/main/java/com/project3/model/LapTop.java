package com.project3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="laptops")
public class LapTop {

	@Id
	@Column(name="serial_number")
	@NotEmpty
	@Size (min=5, max=10, message= "must be between 5 and 10 digits long")
	//@Digits (integer=15, fraction=0)
	private String serialNumber;
	
	@Column(name = "make")
	@NotEmpty
	private String make;
		
	@ManyToOne
	@JoinColumn(name = "emp_id")
	private Employee employee;
	
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
