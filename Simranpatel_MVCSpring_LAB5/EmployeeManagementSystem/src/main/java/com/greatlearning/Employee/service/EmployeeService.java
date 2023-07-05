package com.greatlearning.Employee.service;

import java.util.List;

import com.greatlearning.Employee.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAllEmployees();
	
	public Employee findById(Long theId);
	
	public void save(Employee theEmployee);
	
	public void deleteEmployeeById(Long theId);

	public Employee updateEmployee(Employee employee);
}
