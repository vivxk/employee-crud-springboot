package com.backend.employee.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.backend.employee.entity.Employee;
import com.backend.employee.exceptions.ResourceNotFoundException;
import com.backend.employee.repository.EmpRepoPage;
import com.backend.employee.repository.EmployeeRepo;

@Transactional
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepo employeeRepo;
	@Autowired
	EmpRepoPage employeeRepoPage;

	@Override
	public Employee createEmployee(Employee emp) {
		Employee createdEmployee = this.employeeRepo.save(emp);
		return createdEmployee;
	}

	@Override
	public Employee updateEmployee(Employee employee, Integer empId) {

		Employee emp = this.employeeRepo.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "ID:  ", empId));
		emp.setName(employee.getName());
		emp.setJobTitle(employee.getJobTitle());
		emp.setEmail(employee.getEmail());
		emp.setFullAddress(employee.getFullAddress());
		emp.setPhoneNo(employee.getPhoneNo());
		emp.setEmergencyContactName(employee.getEmergencyContactName());
		emp.setEmergencyContactPhone(employee.getEmergencyContactPhone());
		emp.setRelationship(employee.getRelationship());
		Employee updatedEmployee = this.employeeRepo.save(emp);
		return updatedEmployee;
	}

	@Override
	public void deleteEmployee(int empId) {

		this.employeeRepo.deleteById(empId);
	}

	@Override
	public Employee getEmployeeById(Integer empId) {
		Employee employeeById = this.employeeRepo.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "Id ", empId));

		return employeeById;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> findAllEmployees = this.employeeRepo.findAll();
		return findAllEmployees;
	}

	@Override
	public List<Employee> getPaginatedEmployee(int pageNo, int pageSize) {
		PageRequest paging = PageRequest.of(pageNo, pageSize);
		Page<Employee> pagedResult = employeeRepoPage.findAll(paging);
		return pagedResult.toList();
	}

}
