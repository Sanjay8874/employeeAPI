package com.employee.employeeAPI.Repository;

import com.employee.employeeAPI.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    Employee findByEmail(String email);
    Optional<Employee> findById(Long id);

    @Query("Select e from Employee e where e.salary > ?1")
    List<Employee> findSalaryMoreThen(double salary);

    @Query("Select e from Employee e where e.name=?1")
    Employee findByName(String employeeName);


    List<Employee> findByProjectsName(String projectName);


}
