package com.project3.service;

import org.springframework.stereotype.Service;

@Service ("lapTopService")
public interface LapTopService {
	
				void deleteLapTop(String serialNumber);
}
