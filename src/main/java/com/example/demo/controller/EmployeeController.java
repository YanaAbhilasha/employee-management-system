package com.example.demo.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class EmployeeController {
	private final EmployeeService employeeService;

	@GetMapping
	public String home(Model theModel) {
		theModel.addAttribute("theDate", new Date());
		return "index";
	}
	@GetMapping("/employees")
	public String getAllEmployees(Model theModel)
	{
		theModel.addAttribute("employees",employeeService.getEmployees());
		return "list-employee";
	}
   
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel)
	{
		theModel.addAttribute("employee",new Employee());
		return "employee-form";
	}
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee)
	{
		employeeService.createEmployee(employee);
		return ("redirect:/employees");
	}
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(Model theModel)
	{
//		theModel.addAttribute("employee",);
		return "employee-form";
	}
}