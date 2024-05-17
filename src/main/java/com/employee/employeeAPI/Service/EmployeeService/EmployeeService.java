package com.employee.employeeAPI.Service.EmployeeService;

import com.employee.employeeAPI.Model.Employee;

import java.util.List;

public interface EmployeeService {

    public String isValid(Employee employee);
    public void addEmployee(Employee employee);

    public List<Employee> getEmployeeByProject(String projectName);
}
