package com.technoelevate.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.technoelevate.controller.employeedto.EmployeeInfoBean;
import com.technoelevate.controller.services.EmployeeServiceJdbc;

@Controller
@SessionAttributes("test")
public class HomeController {
	
	@Autowired
	EmployeeServiceJdbc service;
	EmployeeInfoBean employeeInfoBean;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/authenticate")
	public String authenticateEmployee( @RequestParam int id, @RequestParam String fname, 
			@RequestParam String password, ModelMap map, HttpServletRequest request) {
		if (service.authenticate(id, password) != null) {

			HttpSession mySession = request.getSession();
			mySession.setAttribute("myDtoObject", service.authenticate(id, password));

			map.addAttribute("FirstName", fname);
			map.addAttribute("msg", "Logged in successfully");
			return "employeeHome2";
		} else {
			map.addAttribute("msg", "Invalid credentials");
			return "login";
		}
		
	}
	
	
	@GetMapping("/add")
	public String addEmployee(HttpSession myAddSession, ModelMap map,@SessionAttribute("myDtoObject") EmployeeInfoBean info) {
	map.addAttribute("myAddSession",myAddSession.getAttribute("myDtoObject"));
		return "InsertEmployee";
	}
	
	@PostMapping("/add")
	public String insertEmployee(ModelMap map, EmployeeInfoBean employeeInfoBean) {
		
		if (employeeInfoBean != null) {
			service.addEmployee(employeeInfoBean);
			map.addAttribute("AddedEmployee", employeeInfoBean);
			map.addAttribute("msg", "SucessfullyInserted");
		
		} else {
			map.addAttribute("msg", "Failed to insert employee record");
		}
		return "employeeHome";
	}
	
	
	@GetMapping("/allemployee")
	public String getAllEmployees(ModelMap map, EmployeeInfoBean employeeInfoBean) {
		List<EmployeeInfoBean> allEmployees = service.getAllEmployees();
		map.addAttribute("my_Message", "Hello");
		map.addAttribute("All_Employees", allEmployees);// binding the data with the view
		return "employeeAll";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "Login";
	}
}
