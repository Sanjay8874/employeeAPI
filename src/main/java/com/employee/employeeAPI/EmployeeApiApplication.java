package com.employee.employeeAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = "com.employee.employeeAPI.Model")
@ComponentScan(basePackages = {"com.employee.employeeAPI.Repository", "com.employee.employeeAPI.Service", "com.employee.employeeAPI.Controller"})
public class EmployeeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApiApplication.class, args);
	}

}
