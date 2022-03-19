package com.project3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="phones")
public class Phone {
	@Id
	@Column(name="imei")
	@NotEmpty
	@Size (min=15, max=15, message= "must be 15 digits long")
	@Digits (integer=15, fraction=0, message= "")
	private String phoneImei;
	
	@Column(name="make")
	@NotEmpty
	private String phoneMake;
	
	@ManyToOne
	@JoinColumn(name = "emp_id")
	private Employee employee;
	
	public String getPhoneImei() {
		return phoneImei;
	}
	public void setPhoneImei(String phoneImei) {
		this.phoneImei = phoneImei;
	}
	public String getPhoneMake() {
		return phoneMake;
	}
	public void setPhoneMake(String phoneMake) {
		this.phoneMake = phoneMake;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "Phone [phoneImei=" + phoneImei + ", phoneMake=" + phoneMake + ", employee=" + employee + "]";
	}
	
    
	
}
