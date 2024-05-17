package com.employee.employeeAPI.Controller;
import com.employee.employeeAPI.Model.Employee;
import com.employee.employeeAPI.Service.APICallerService;
import com.employee.employeeAPI.Service.EmployeeService.EmployeeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeServiceImpl employeeService;

    @Autowired
    APICallerService apiCallerService;


    @PostMapping("/addEmployee")
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        logger.info("New Employee added Successfully");
    }

    //It will return all employee from database.
    @GetMapping("/getEmployee")
    public List<Employee> getAllEmployee() {
        logger.info("All Employee retrieved Successfully");
        return employeeService.getAllEmployee();
    }

    @GetMapping("/getEmployeeById")
    public Optional<Employee> getByID(@RequestParam("id") Long id) {
        return employeeService.getById(id);

    }

    @DeleteMapping("/deleteEmployee")
    public String deleteEmployee() {
        employeeService.deleteAllEmployee();
        logger.info("Employee Deleted");
        return "All Employee Deleted";
    }


    //Get Method to call the External API
    @GetMapping("/externalApiCall")
    public Object apiCaller() throws URISyntaxException, IOException, InterruptedException {
        URI uri = new URI("https://restcountries.com/v3.1/all");
        return apiCallerService.apiCaller(uri);
    }

    // Find the Salary which is more than X.
    @GetMapping("/salary")
    public List<List<Employee>> getSalary(@RequestParam("salary") double salary) {
        return employeeService.findSalary(salary);
    }

    @GetMapping("/getEmployeeByProject/{projectName}")
    public List<Employee> getEmployeeByProject(@PathVariable String projectName){
        return employeeService.getEmployeeByProject(projectName);

    }


    @GetMapping("/getEmployeeNameByProject/{projectName}")
    public List<String> getEmployeeNameByProject(@PathVariable String projectName){
        return employeeService.getEmployeeNameByProject(projectName);
    }

    @GetMapping("/numberOfEmployee/{departmentName}")
    public Long numberOfEmployee(@PathVariable String departmentName){
        return employeeService.countEmployeeByDepartment(departmentName);
    }
}