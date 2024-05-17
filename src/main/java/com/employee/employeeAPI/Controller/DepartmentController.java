package com.employee.employeeAPI.Controller;

import com.employee.employeeAPI.Model.Department;
import com.employee.employeeAPI.Service.DepartmentService.DepartmentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/Department")
public class DepartmentController {

    private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    DepartmentServiceImpl departmentService;

    @PostMapping("/addDepartment")
    public String addDepartment(@RequestBody Department department){
        departmentService.addDepartment(department);
        logger.info("New Department Added Successfully");
        return "New Department Added";
    }


    @DeleteMapping("/deleteDepartment")
    public String deleteAllProject(){
        departmentService.deleteAllDepartment();
        logger.info("Department deleted");
        return "All Department Deleted";
    }
}
