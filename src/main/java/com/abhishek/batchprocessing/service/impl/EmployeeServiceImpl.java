package com.abhishek.batchprocessing.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abhishek.batchprocessing.entity.Employee;
import com.abhishek.batchprocessing.exception.RecordNotAddedException;
import com.abhishek.batchprocessing.exception.RecordNotDeletedException;
import com.abhishek.batchprocessing.exception.RecordNotFoundException;
import com.abhishek.batchprocessing.repository.EmployeeRepository;
import com.abhishek.batchprocessing.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public List<Employee> getAllEmployees() {
		return this.empRepo.findAll();
	}

	@Override
	public String saveAllEmployee(List<Employee> employees) throws RecordNotAddedException {
		
		try {
			this.empRepo.saveAll(employees);
			
			return "Employees saved succesfully. Size - "+employees.size();
		} catch (DataAccessException e) {
			
			String message= "Employee creation failed. Check the data again.";
			
			throw new RecordNotAddedException(message, e);
		}
		
		
	}

	@Override
	public String saveEmployee(Employee newEmployee) throws RecordNotAddedException {
		
		try {
			this.empRepo.save(newEmployee);
			
			return "Employee saved successfully -" + newEmployee.getName();
		} catch (DataAccessException e) {
			
			String message= "Employee creation failed. Check the data again.";
			
			throw new RecordNotAddedException(message, e);
		}
		
		
	}

	@Override
	public Employee getEmployeeById(long id) throws RecordNotFoundException {
		
//		try {
//			Employee emp = this.employeeData()
//			           .stream()
//			           .filter( e -> e.getId() == id)
//			           .findFirst()
//			           .get();
//			return emp;
//		
//		} catch(NoSuchElementException e) {
//			
//			Employee emp = new Employee();
//			emp.setId(-1);
//			return emp;
//		}
		
		try {
		
		Employee emp = this.empRepo.findById(id).get();
		return emp;
		} catch (NoSuchElementException e) {
//			Employee emp = new Employee();
//			emp.setId(-1);
//			return emp;
			String message =  "Employee not found with id - "+id;
			throw new RecordNotFoundException(message, e);
		}
		
	}

	@Override
	@Transactional
	public String deleteEmployee(long id) throws RecordNotDeletedException {
		
		try {
			this.empRepo.deleteById(id);
			return "Employee id - "+id+" deleted successfully";
		} catch (EmptyResultDataAccessException e) {
			String message =  "Employee id - "+id+" delete operation failed.";
			throw new RecordNotDeletedException(message, e);
		}
		
	}

	@Override
	@Transactional
	public String updateEmployee(Employee updatedEmployee) throws RecordNotAddedException {
		
		if(this.empRepo.existsById(updatedEmployee.getId())) {
			
			Employee existingEmployee = this.empRepo.findById(updatedEmployee.getId()).get();
			
			
			existingEmployee.setName(updatedEmployee.getName());
			existingEmployee.setLocation(updatedEmployee.getLocation());
			existingEmployee.setDept(updatedEmployee.getDept());
			
//			this.empRepo.save(existingEmployee);
			
			this.saveEmployee(existingEmployee);
			return "Employee updated successfully";
		} else {
			String message = "Update Operation failed. No employee with id - "+updatedEmployee.getId()+ " found in the system";
			
			throw new RecordNotAddedException(message);
		}
		
	}

	private List<Employee> employeeData() {

		List<Employee> employees = new ArrayList<>();

		Employee emp1 = new Employee();
		emp1.setId(1);
		emp1.setName("John Doe");
		emp1.setDept("CCIB");
		emp1.setLocation("Singapore");

		employees.add(emp1);

		emp1 = new Employee();
		emp1.setId(2);
		emp1.setName("Ram Narayan");
		emp1.setDept("Retail");
		emp1.setLocation("Chennai");

		employees.add(emp1);

		emp1 = new Employee();
		emp1.setId(3);
		emp1.setName("Ravi Prasad");
		emp1.setDept("ET");
		emp1.setLocation("Bengaluru");

		employees.add(emp1);

		return employees;

	}

}
