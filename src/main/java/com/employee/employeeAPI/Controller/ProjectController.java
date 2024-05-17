package com.employee.employeeAPI.Controller;


import com.employee.employeeAPI.Model.Project;
import com.employee.employeeAPI.Service.ProjectService.ProjectServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Project")
public class ProjectController {

    private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);

    @Autowired
    ProjectServiceImpl projectService;

    @PostMapping("/addProject")
    public String addProject(@RequestBody Project project){
        projectService.addProject(project);
        return "New Project Added";
    }

    @GetMapping("/getProjectByEmployeeName/{employeeName}")
    public ResponseEntity<List<Project>> getProject(@PathVariable String employeeName){
        List<Project> projectList = projectService.findProjectByEmployeeName(employeeName);
        if(!projectList.isEmpty()){
            return ResponseEntity.ok(projectList);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    // Get name of Project only
    @GetMapping("/getProjectName/{employeeName}")
    public List<String> getProjectName(@PathVariable String employeeName){
        List<String> projectList = projectService.findNameOfProject(employeeName);
        return projectList;
    }

    @DeleteMapping("/deleteProject")
    public String deleteAllProject(){
        projectService.deleteAllProject();
        logger.info("Project Deleted");
        return "All Project Deleted";
    }




}
