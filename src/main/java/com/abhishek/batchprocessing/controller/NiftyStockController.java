package com.abhishek.batchprocessing.controller;

import java.util.HashMap;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhishek.batchprocessing.ApiSuccessResponse;
import com.abhishek.batchprocessing.exception.RecordNotAddedException;

@RestController
@RequestMapping("/nifty")
public class NiftyStockController {
	
	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
	@Qualifier("nifty_stock_batch")
	private Job job;
	
	@GetMapping("/batch")
	public ResponseEntity<?> loadNiftyStockData() throws RecordNotAddedException {
		
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
			throw new RecordNotAddedException("Batch Processing of nifty failed", e);
		}
		
		
		

	}

}
