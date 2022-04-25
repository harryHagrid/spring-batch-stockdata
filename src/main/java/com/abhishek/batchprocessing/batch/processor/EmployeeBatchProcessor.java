package com.abhishek.batchprocessing.batch.processor;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.abhishek.batchprocessing.entity.Employee;

@Component
public class EmployeeBatchProcessor implements ItemProcessor<Employee, Employee> {
	
	private Logger LOGGER = LoggerFactory.getLogger(EmployeeBatchProcessor.class);

	@Override
	public Employee process(Employee employee) throws Exception {
		
		/*
		 * Process logic goes here below.
		 */
		
		employee.setTimestamp(LocalDateTime.now());
		
		LOGGER.info("Employee Proccessing from file");
		
		return employee;
	}

}
