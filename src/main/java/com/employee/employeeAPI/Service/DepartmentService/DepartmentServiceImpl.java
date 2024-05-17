package com.employee.employeeAPI.Service.DepartmentService;

import com.employee.employeeAPI.Model.Department;
import com.employee.employeeAPI.Repository.DepartmentRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    private static final Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);
    @Autowired
    DepartmentRepo departmentRepo;

    public void addDepartment(Department department){
        Department depName = departmentRepo.findByName(department.getName());
        if(depName!=null){
            logger.error("Department Already Exist");
        }
        else {
            departmentRepo.save(department);
            logger.info("Department added");
        }

    }

    public void deleteAllDepartment(){
        departmentRepo.deleteAll();;
    }

}
