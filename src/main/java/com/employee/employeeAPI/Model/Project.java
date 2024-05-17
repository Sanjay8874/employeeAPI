package com.employee.employeeAPI.Model;


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
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private int id;

    @Column(name = "project_name")
    private String name;

    //@JsonManagedReference
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "projects")
    private Set<Employee> employees;

    @ManyToOne
    private Department department;

}
