package com.project3.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.project3.model.Phone;

@Repository("restRepository")
public class RESTRepository {
	List<Phone>  phoneMakes= new ArrayList<Phone>();
	Phone phone1 = new Phone();
	Phone phone2 = new Phone();
	Phone phone3 = new Phone();
	Phone phone4 = new Phone();
	Phone phone5 = new Phone();
	
	public List<Phone> getAllPhoneMakes(){
	
	phone1.setPhoneMake("Iphone");
	phone2.setPhoneMake("Samsung");
	phone3.setPhoneMake("Nokia");
	phone4.setPhoneMake("HTC");
	phone5.setPhoneMake("Sony Ericsson");

	if(phoneMakes.isEmpty()) {
		
	phoneMakes.add(phone1);
	phoneMakes.add(phone2);
	phoneMakes.add(phone3);
	phoneMakes.add(phone4);
	phoneMakes.add(phone5);
	}
	
	return phoneMakes;
	}
	
	public Phone addPhoneMake(Phone phone) {
		phoneMakes.add(phone);
		return null;
	}
}
