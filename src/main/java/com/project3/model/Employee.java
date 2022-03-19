package com.project3.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.URL;

@Entity
@Table (name="employees")
public class Employee {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;

	@Column(name="name")
	@NotEmpty
	private String name;
		
	@Column(name="address")
	@NotEmpty
	@Pattern(regexp = "^[a-zA-Z]{1,2}([0-9]{1,2}|[0-9][a-zA-Z])\\s*[0-9][a-zA-Z]{2}$", message="must be a valid UK post code")
	private String address;
		
	@Column(name="email")
	@NotEmpty
	@Email
	private String email;
	
	@Column(name="photo")
	@NotEmpty
	@URL
	private String photo;
	
	@OneToMany (mappedBy = "employee", cascade=CascadeType.ALL, fetch = FetchType.LAZY )
	private List<Phone> phones = new ArrayList<Phone>();
	
	@OneToMany (mappedBy = "employee", cascade=CascadeType.ALL, fetch = FetchType.LAZY )
	private List<LapTop> laptops = new ArrayList<LapTop>();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public List<LapTop> getLaptops() {
		return laptops;
	}

	public void setLaptops(List<LapTop> laptops) {
		this.laptops = laptops;
	}
	
	
}
