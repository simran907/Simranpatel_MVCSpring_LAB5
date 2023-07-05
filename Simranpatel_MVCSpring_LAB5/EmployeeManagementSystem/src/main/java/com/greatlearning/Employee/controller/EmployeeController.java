package com.greatlearning.Employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.greatlearning.Employee.entity.Employee;
import com.greatlearning.Employee.service.EmployeeService;

@Controller
@RequestMapping("/")
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@GetMapping("/employee")
	public String listEmployees(Model theModel) {
		List<Employee> theEmployee = employeeService.findAllEmployees();
		theModel.addAttribute("employee",theEmployee);
		return "employee";
	}
	 
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Employee theEmployee = new Employee();
		theModel.addAttribute("employee",theEmployee);
		return "create_employee";
	}
	
	@PostMapping("/employee/{id}")
	public String updateemployee(@PathVariable Long id, @ModelAttribute("employee") Employee employee, Model model) {

		// get employee from database by id
		Employee existingEmployee = employeeService.findById(id);
		existingEmployee.setId(id);
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());

		// save updated employee object
		employeeService.updateEmployee(existingEmployee);
		return "redirect:/employee";
	}
	
	@PostMapping("/employee")
	public String save(@ModelAttribute("employee")Employee theEmployee) {
		employeeService.save(theEmployee);
		return "redirect:/employee";
	}
	
	@GetMapping("/employee/edit/{id}")
	public String editemployeeForm(@PathVariable Long id, Model model) {
		model.addAttribute("employee", employeeService.findById(id));
		return "edit_employee";
	}
	
	@GetMapping("/employee/{id}")
	public String delete(@PathVariable Long id) {
		employeeService.deleteEmployeeById(id);
		return "redirect:/employee";
	}
}
