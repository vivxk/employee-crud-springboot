package com.backend.employee.service;

import java.util.List;

import com.backend.employee.entity.Employee;

public interface EmployeeService {

	Employee createEmployee(Employee emp);

	Employee updateEmployee(Employee emp, Integer empId);

	void deleteEmployee(int empId);

	Employee getEmployeeById(Integer empId);

	List<Employee> getAllEmployees();

	List<Employee> getPaginatedEmployee(int pageNo, int pageSize);

}
