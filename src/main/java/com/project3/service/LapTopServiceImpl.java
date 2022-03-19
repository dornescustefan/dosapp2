package com.project3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project3.repository.LapTopRepository;

@Service ("lapTopService")
public class LapTopServiceImpl implements LapTopService {

	@Autowired
	LapTopRepository lapTopRepository ;
	
	@Transactional
	public void deleteLapTop(String serialNumber) {
		lapTopRepository.deleteById(serialNumber);
		
	}
	

}
