package com.employee.employeeAPI.Repository;


import com.employee.employeeAPI.Model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {
Department findByName(String depName);

}

