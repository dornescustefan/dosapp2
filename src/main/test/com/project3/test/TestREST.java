package com.project3.test;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import com.project3.model.Phone;

public class TestREST {

	@Test(timeout=9000)
	public void testAddPhone() {
		RestTemplate restTemplate = new RestTemplate();

		Phone phone = new Phone();
		phone.setPhoneMake("Test Phone");
		restTemplate.postForObject("http://localhost:8080/EmployeeAssets/addphonemake", phone, Phone.class);
		
		System.out.println("Phones: " + phone);
	}
	


}
