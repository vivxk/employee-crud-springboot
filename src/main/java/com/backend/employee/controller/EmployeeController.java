package com.backend.employee.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.employee.entity.Employee;
import com.backend.employee.exceptions.ApiResponse;
import com.backend.employee.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping("/")
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
		Employee createdEmployee = this.employeeService.createEmployee(employee);
		return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);

	}

	@PutMapping("/{empId}")
	public ResponseEntity<Employee> updateEmployee(@Valid @RequestBody Employee employee, @PathVariable int empId) {
		Employee updatedEmployee = this.employeeService.updateEmployee(employee, empId);
		return new ResponseEntity<>(updatedEmployee, HttpStatus.CREATED);

	}

	@GetMapping("/{empId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int empId) {
		Employee employeeById = this.employeeService.getEmployeeById(empId);
		return ResponseEntity.ok(employeeById);

	}

	@GetMapping("/")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> allEmployees = this.employeeService.getAllEmployees();
		return ResponseEntity.ok(allEmployees);

	}

	@GetMapping("")
	public ResponseEntity<List<Employee>> getPaginatedEmployees(@RequestParam int pageNo, @RequestParam int pageSize) {

		return ResponseEntity.ok(employeeService.getPaginatedEmployee(pageNo, pageSize));
	}

	@DeleteMapping("/{empid}")
	public ResponseEntity<ApiResponse> deleteEmployee(@PathVariable int empid) {
		this.employeeService.deleteEmployee(empid);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully", true), HttpStatus.GONE);
	}

}
