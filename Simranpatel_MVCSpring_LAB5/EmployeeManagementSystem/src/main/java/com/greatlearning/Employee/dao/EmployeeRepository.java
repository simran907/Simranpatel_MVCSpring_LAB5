package com.greatlearning.Employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.Employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
