package com.employee.employeeAPI.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Builder
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private int id;

    @Column(name = "department_name")
    private String name;


    //@JsonBackReference
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private Set<Employee> employees;


    @OneToMany(mappedBy = "department")
     private Set<Project> projects;
}
