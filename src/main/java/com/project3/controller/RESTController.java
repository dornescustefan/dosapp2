package com.project3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project3.model.Phone;
import com.project3.service.RESTService;

@RestController
public class RESTController {
	@Autowired
	RESTService restService;
	//REST API Controller
			@RequestMapping(value="phonemakes", method = RequestMethod.GET)
			@ResponseBody
			public List<Phone> getAllPhoneMakes(){
				
				return restService.getAllPhoneMakes();
				}
			
			@RequestMapping(value="addphonemake", method = RequestMethod.POST)
			public Phone addPhoneMake(@RequestBody Phone phone){
			
				restService.addPhonMake(phone);
				return phone;				
				}
		

}
