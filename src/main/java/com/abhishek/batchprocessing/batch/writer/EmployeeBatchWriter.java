package com.abhishek.batchprocessing.batch.writer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.abhishek.batchprocessing.entity.Employee;
import com.abhishek.batchprocessing.repository.EmployeeRepository;

@Component
public class EmployeeBatchWriter implements ItemWriter<Employee> {
	
	private final Logger LOGGER = LoggerFactory.getLogger(EmployeeBatchWriter.class);
	
	@Autowired
	private EmployeeRepository empRepo;

	@Override
	@Transactional
	public void write(List<? extends Employee> items) throws Exception {
		
		this.empRepo.saveAll(items);
		
		LOGGER.info("Employee saved successfully in the process");
		
	
	}
	

}
