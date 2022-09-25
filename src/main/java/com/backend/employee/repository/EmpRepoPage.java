package com.backend.employee.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.backend.employee.entity.Employee;

public interface EmpRepoPage extends PagingAndSortingRepository<Employee, Integer> {

}
