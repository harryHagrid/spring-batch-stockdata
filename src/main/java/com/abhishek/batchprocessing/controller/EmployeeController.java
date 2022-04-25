package com.abhishek.batchprocessing.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.abhishek.batchprocessing.ApiSuccessResponse;
import com.abhishek.batchprocessing.entity.Employee;
import com.abhishek.batchprocessing.exception.RecordNotAddedException;
import com.abhishek.batchprocessing.exception.RecordNotDeletedException;
import com.abhishek.batchprocessing.exception.RecordNotFoundException;
import com.abhishek.batchprocessing.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/employee")
@CrossOrigin
@Tag(name = "Employee", description = "APIs related to Employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
	@Qualifier("emp_job")
	private Job job;

	@GetMapping("/")
	@Operation(summary = "Get all employees", description = "Get all employees")
	public ResponseEntity<?> getAllEmployees() {

		ApiSuccessResponse response = new ApiSuccessResponse();

		List<Employee> employees = this.employeeService.getAllEmployees();

		response.setMessage("Employees found. Size - " + employees.size());
		response.setBody(employees);
		response.setSuccess(true);
		response.setStatus(HttpStatus.OK);

		return ResponseEntity
				.status(HttpStatus.OK)
				.header("status", String.valueOf(HttpStatus.FOUND))
				.body(response);

	}

	@GetMapping("/{id}")
	@Operation(summary = "Get Employee by Id", description = "Get employee by ID")
	
	public ResponseEntity<?> getEmployeeById(
			@Parameter(description = "Type the employee id", example = "1") 
			@PathVariable long id)
			throws RecordNotFoundException {

		ApiSuccessResponse response = new ApiSuccessResponse();

		Employee emp = this.employeeService.getEmployeeById(id);

		response.setMessage("Employee found with id - " + id);
		response.setBody(emp);
		response.setStatus(HttpStatus.OK);
		response.setSuccess(true);

		return ResponseEntity
				.status(HttpStatus.OK)
				.header("status", String.valueOf(HttpStatus.FOUND))
				.body(response);

	}

	@PostMapping("/")
	@Operation(summary = "Create new employee", description = "Create new Employee")
	public ResponseEntity<?> saveEmployee(
			@Parameter(description = "Pass the employee model") 
			@RequestBody Employee newEmployee)
			throws RecordNotAddedException {

		ApiSuccessResponse response = new ApiSuccessResponse();

		String message = this.employeeService.saveEmployee(newEmployee);

		response.setMessage("Employee created");
		response.setBody(message);
		response.setStatus(HttpStatus.CREATED);
		response.setSuccess(true);

		return ResponseEntity
				.status(HttpStatus.CREATED)
				.header("status", String.valueOf(HttpStatus.CREATED))
				.body(response);

	}

	@PutMapping("/")
	@Operation(summary = "Update employee with new detail")
	public ResponseEntity<?> updateEmployee(
			@Parameter(description = "Pass the updated employee data") 
			@RequestBody Employee updatedData)
			throws RecordNotAddedException {

		ApiSuccessResponse response = new ApiSuccessResponse();
		String message = this.employeeService.updateEmployee(updatedData);

		response.setMessage("Employee updated");
		response.setBody(message);
		response.setStatus(HttpStatus.CREATED);
		response.setSuccess(true);

		return ResponseEntity
				.status(HttpStatus.OK)
				.header("status", String.valueOf(HttpStatus.CREATED))
				.body(response);

	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Delete the employee by id")
	public ResponseEntity<?> deleteEmployeeById(
			@Parameter(description = "Type the id", example = "1") 
	        @PathVariable long id) throws RecordNotDeletedException {

		ApiSuccessResponse response = new ApiSuccessResponse();
		String message = this.employeeService.deleteEmployee(id);
		
		response.setMessage("Employee deleted");
		response.setBody(message);
		response.setStatus(HttpStatus.OK);
		response.setSuccess(true);


		return ResponseEntity
				.status(HttpStatus.OK)
				.header("status", String.valueOf(HttpStatus.ACCEPTED))
				.body(response);

	}
	
	
	@GetMapping("/batch")
	@Operation(summary = "Batch processing of employee file and saving into database")
	public ResponseEntity<?> saveEmployeeInBatch() throws RecordNotAddedException  {

		ApiSuccessResponse response = new ApiSuccessResponse();
		
		Map<String, JobParameter> maps = new HashMap<>();
		
		maps.put("timestamp", new JobParameter(System.currentTimeMillis()));
		
		JobParameters parameters = new JobParameters(maps);
		
		
		JobExecution execution;
		try {
			execution = jobLauncher.run(job, parameters);
			response.setMessage("Status- "+execution.getStatus());
			response.setBody( 
					" Start Time: " + execution.getStartTime()+ 
					" End Time: "+ execution.getEndTime());
			response.setStatus(HttpStatus.OK);
			response.setSuccess(true);
			
			
			return ResponseEntity
				   .status(HttpStatus.OK)
				   .header("status", String.valueOf(HttpStatus.ACCEPTED))
				   .body(response);
			


			
		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
				| JobParametersInvalidException e) {
			// TODO Auto-generated catch block
			throw new RecordNotAddedException("Batch Processing of employee failed", e);
		}
		
		
		

	}
	
	

}
