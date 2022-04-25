package com.abhishek.batchprocessing;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.abhishek.batchprocessing.entity.Employee;
import com.abhishek.batchprocessing.service.EmployeeService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
//@OpenAPIDefinition(
//		info = @Info(title = "Spring Boot APIs",
//					description = "Backend Application Development",
//					version = "1.0")
//)
//@EnableConfigurationProperties
public class BatchProcessingApplication implements CommandLineRunner {
	
	@Autowired
	private EmployeeService empService;

	public static void main(String[] args) {
		SpringApplication.run(BatchProcessingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println(this.empService.saveAllEmployee(this.employeeData()));
		
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
