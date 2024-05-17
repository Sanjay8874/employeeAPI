package com.employee.employeeAPI.Service.EmployeeService;



import com.employee.employeeAPI.Model.Employee;

import com.employee.employeeAPI.Repository.EmployeeRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class EmployeeServiceImpl implements EmployeeService {


    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    @Autowired
    EmployeeRepo employeeRepo;
    @Override
    public void addEmployee(Employee employee) {
        String valid = isValid(employee);
        if (valid == "1") {
            logger.info("Validated done");
        } else {
            logger.error("Validation failed check input");
        }
    }

    // Find the Salary which is more than X.
    public List<List<Employee>> findSalary(double sal) {
        ArrayList<List<Employee>> emp = new ArrayList<>();
        emp.add(employeeRepo.findSalaryMoreThen(sal));
        return emp;
    }

    //To add New Department
    public List<Employee> getAllEmployee() {
        return employeeRepo.findAll();
    }

    public Optional<Employee> getById(Long id) {
        Optional<Employee> emp = null;
        try {
            emp = employeeRepo.findById(id);
            if (emp.isPresent()) {
                return emp;
            } else {
                logger.error("Employee is not present by id " + id);
            }
        } catch (NullPointerException n) {
            logger.error("NullPointer Exception occur Employee Id is null");
        }

        return emp;
    }

    // put validator on User input
    @Override
    public String isValid(Employee emp) {
        //check Employee Exist in database or not use the email to verify it.
        Employee existEmployee = employeeRepo.findByEmail(emp.getEmail());
        if (existEmployee != null) {
            logger.error("Employee Already Present ");
        } else {
            employeeRepo.save(emp);
            logger.info("Employee added");
        }

        if (emp.getName() != null && !emp.getName().isEmpty() && emp.getName().matches("^[a-zA-Z\\s]*$")) {
            logger.info("User name validated Successfully");
        } else {
            logger.error("Failed to Validate user name, name Should be String only, Should not be null or empty");
        }

        if (emp.getAge() == null) {
            logger.info("Given String is null");
        } else {
            if (emp.getAge() != null && !emp.getAge().isEmpty()) {
                try {
                    int age = Integer.parseInt(emp.getAge());
                    if (age <= 30) {
                        logger.info("User age validated Successfully");
                    } else {
                        logger.error("Failed to Validate Age, Age Should be less then 30, Should not be null or empty");

                    }
                } catch (NumberFormatException exception) {
                    logger.error("Number format Exception " + exception);
                }
            }
        }
        if (emp.getPhone() == null) {
            logger.error("Given Phone is null");
        } else {
            if (emp.getPhone() != null && !emp.getPhone().isEmpty()) {
                try {
                    if (emp.getPhone().length() == 10) {
                        logger.info("User Phone length validated");
                    } else {
                        logger.error("Failed to Validate Phone, length should be less then 10, Should not be null or empty ");
                    }
                } catch (NumberFormatException exception) {
                    logger.error("Number format Exception " + exception);
                }
            }
        }
        return "1";
    }

    //Delete all Employee from DB
    public void deleteAllEmployee(){
        employeeRepo.deleteAll();
    }

    @Override
    public List<Employee> getEmployeeByProject(String projectName) {
       List<Employee> employee  = employeeRepo.findByProjectsName(projectName);
       return employee;
    }


    public List<String> getEmployeeNameByProject(String projectName){
        List<Employee> employee  = employeeRepo.findByProjectsName(projectName);
        List<String> emp = new ArrayList<>();
        for(Employee e: employee){
            emp.add(e.getName());
        }
        return emp;
    }

}
