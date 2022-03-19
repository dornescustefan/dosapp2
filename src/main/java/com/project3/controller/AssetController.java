package com.project3.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project3.model.Employee;
import com.project3.model.LapTop;
import com.project3.model.Phone;
import com.project3.service.EmployeeService;
import com.project3.service.LapTopService;
import com.project3.service.PhoneService;

@Controller
public class AssetController {

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	PhoneService phoneService;
	
	@Autowired
	LapTopService lapTopService;
	
	ModelAndView mv = new ModelAndView();
	//Retrieve employee to add phone
	@RequestMapping(value="/addPhone{id}", method = RequestMethod.GET)
	public ModelAndView addPhone(@ModelAttribute("savePhoneForm")Phone phone, @PathVariable int id) {
		Employee employee = employeeService.findEmployeeById(id);
		mv.setViewName("addPhone");
		mv.addObject("name", employee.getName());
		mv.addObject("id", employee.getId());
		return mv;
	}
	
	//Save phone for an Employee
	@RequestMapping(value="/savePhone", method=RequestMethod.POST)
	public ModelAndView savePhone(@Valid @ModelAttribute("savePhoneForm")Phone phone, BindingResult result, @ModelAttribute("employee")Employee employee) 
		{
		if (result.hasErrors()) {
            return new ModelAndView("addPhone"); 
        }
		int id = (Integer) mv.getModel().get("id");
		employee = employeeService.findEmployeeById(id);
		employee.getPhones().add(phone);
		phone.setEmployee(employee);
		employeeService.save(employee);
		return new ModelAndView("redirect:/viewEmployees"); 
	}
	
	//Delete phone
	@RequestMapping(value="/deletePhone{phoneImei}", method=RequestMethod.GET)
	public ModelAndView deletePhoneByImei(@PathVariable String phoneImei) {
		phoneService.deletePhone(phoneImei);
		return new ModelAndView("redirect:/viewEmployees"); 
	}
	
	//Retrieve employee to add LapTop	
	@RequestMapping(value="/addLaptop{id}", method = RequestMethod.GET)
	public ModelAndView addLaptop(@ModelAttribute("saveLaptopForm")LapTop laptop, @PathVariable int id) {
		Employee employee = employeeService.findEmployeeById(id);
		mv.setViewName("addLaptop");
		mv.addObject("name", employee.getName());
		mv.addObject("id", employee.getId());
		return mv;
	}
	
	//Save LapTop for an Employee
	@RequestMapping(value="/saveLaptop", method=RequestMethod.POST)
	public ModelAndView saveLaptop(@Valid @ModelAttribute("saveLaptopForm")LapTop laptop, BindingResult result, @ModelAttribute("anemployee")Employee anemployee ) 
		{
		if (result.hasErrors()) {
            return new ModelAndView("addLaptop"); 
        }
		int id = (Integer) mv.getModel().get("id");
		anemployee = employeeService.findEmployeeById(id);
		anemployee.getLaptops().add(laptop);
		laptop.setEmployee(anemployee);
		employeeService.save(anemployee);
		return new ModelAndView("redirect:/"); 
	}
	
	//Delete LapTop
		@RequestMapping(value="/deleteLapTop{serialNumber}", method=RequestMethod.GET)
		public ModelAndView deleteLaptopBySerialNumber(@PathVariable String serialNumber) {
			lapTopService.deleteLapTop(serialNumber);
			return new ModelAndView("redirect:/viewEmployees"); 
		}
}
