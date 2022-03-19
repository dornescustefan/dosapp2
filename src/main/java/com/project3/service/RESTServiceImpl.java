package com.project3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project3.model.Phone;
import com.project3.repository.RESTRepository;

@Service("RESTService")
public class RESTServiceImpl implements RESTService {
	
	@Autowired
	RESTRepository repository;

	public List<Phone>  getAllPhoneMakes(){
		
		return  repository.getAllPhoneMakes();
		
	}

	public Phone addPhonMake(Phone phone) {
		System.out.println(phone);
		repository.addPhoneMake(phone);
		
		return phone;
	}

}
