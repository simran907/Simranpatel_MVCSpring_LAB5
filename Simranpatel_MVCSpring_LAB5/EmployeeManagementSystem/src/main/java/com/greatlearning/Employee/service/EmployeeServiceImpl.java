package com.greatlearning.Employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.Employee.dao.EmployeeRepository;
import com.greatlearning.Employee.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	// types of injection methods in spring- by field, by constructor, by setter

	@Autowired // constructor injection
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> findAllEmployees() {
		List<Employee> theEmployees = employeeRepository.findAll();
		return theEmployees;
	}

	@Override
	public Employee findById(Long theId) {
		Optional<Employee> result = employeeRepository.findById(theId);

		Employee theEmployee = null;
		if (result.isPresent()) {
			theEmployee = result.get();
		} else
			throw new RuntimeException("Did not find book id- " + theId);
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployeeById(Long theId) {
		employeeRepository.deleteById(theId);
	}

}
