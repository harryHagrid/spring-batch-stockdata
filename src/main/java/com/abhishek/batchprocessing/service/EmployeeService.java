package com.abhishek.batchprocessing.service;

import java.util.List;

import com.abhishek.batchprocessing.entity.Employee;
import com.abhishek.batchprocessing.exception.RecordNotAddedException;
import com.abhishek.batchprocessing.exception.RecordNotDeletedException;
import com.abhishek.batchprocessing.exception.RecordNotFoundException;

public interface EmployeeService {
	
	
	public List<Employee> getAllEmployees();
	
	public String saveAllEmployee(List<Employee> employees) throws RecordNotAddedException;
	
	public String saveEmployee(Employee newEmployee) throws RecordNotAddedException;
	
	public Employee getEmployeeById(long id) throws RecordNotFoundException;
	
	public String deleteEmployee(long id) throws RecordNotDeletedException;
	
	public String updateEmployee(Employee updatedEmployee) throws RecordNotAddedException;

}
