package com.project3.service;

import java.util.List;

import com.project3.model.Phone;

public interface RESTService {
	 List<Phone>  getAllPhoneMakes();

	Phone addPhonMake(Phone phone);
    
}
