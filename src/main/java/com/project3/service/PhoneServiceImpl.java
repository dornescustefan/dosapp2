package com.project3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project3.model.Phone;
import com.project3.repository.PhoneRepository;

@Service("phoneService")
public class PhoneServiceImpl implements PhoneService{

	@Autowired
	PhoneRepository phoneRepository;
	
	@Transactional
	public Phone savePhone(Phone phone) {
		return phoneRepository.save(phone);
	}
	
	public void deletePhone(String phoneImei) {
		phoneRepository.deleteById(phoneImei);
	} 

}
