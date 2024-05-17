package com.employee.employeeAPI.Repository;

import com.employee.employeeAPI.Model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepo extends JpaRepository<Project, Integer> {

    Project findByName(String projectName);


}
