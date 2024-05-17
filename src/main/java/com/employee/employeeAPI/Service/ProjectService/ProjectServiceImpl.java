package com.employee.employeeAPI.Service.ProjectService;

import com.employee.employeeAPI.Model.Employee;
import com.employee.employeeAPI.Model.Project;
import com.employee.employeeAPI.Repository.EmployeeRepo;
import com.employee.employeeAPI.Repository.ProjectRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService{

    private static final Logger logger = LoggerFactory.getLogger(ProjectServiceImpl.class);
    @Autowired
    ProjectRepo projectRepo;

    @Autowired
    EmployeeRepo employeeRepo;

    public void addProject(Project project) {
        Project projectName = projectRepo.findByName(project.getName());
        if (projectName != null) {
            logger.info("The Project Already Exist");
        } else {
            projectRepo.save(project);
            logger.info("New Project added");
        }
    }

    public List<Project> findProjectByEmployeeName(String empName){
        Employee employee = employeeRepo.findByName(empName);
        if (employee!=null){
            return new ArrayList<>(employee.getProjects());
        }
        else {
            return Collections.emptyList();
        }

    }


    // Find the name of project only

    public List<String> findNameOfProject(String employeeName){
        if ( employeeName!=null) {
            Employee employee = employeeRepo.findByName(employeeName);
            if (employee != null) {
                List<String> projectList = new ArrayList<>();
                for (Project project : employee.getProjects()) {
                    projectList.add(project.getName());
                }
                return projectList;
            } else {
                logger.error("List is Empty");
                return Collections.emptyList();

            }
        }
        else{
            throw new NullPointerException("Name is Null");
        }
    }

    public void deleteAllProject(){
        projectRepo.deleteAll();
    }





    /*----------------------------------- CHECK LATER -----------------------------------------------------*/
   // This method need to check it later,,,,
    public void addProjectToEmployee(Long employeeId, Integer projectId) {
        Employee employee = employeeRepo.findById(employeeId).orElseThrow(EntityNotFoundException::new);
        Project project = projectRepo.findById(projectId).orElseThrow(EntityNotFoundException::new);
        // Associate employee with project bidirectionally
        employee.getProjects().add(project);
        project.getEmployees().add(employee);
        // Save entities to trigger cascade
        employeeRepo.save(employee);
        projectRepo.save(project);
    }
}
