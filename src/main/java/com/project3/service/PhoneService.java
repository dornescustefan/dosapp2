package com.project3.service;

import com.project3.model.Phone;

public interface PhoneService {

	Phone savePhone(Phone phone);
	void deletePhone(String phoneImei);
}
