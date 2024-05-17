package com.employee.employeeAPI.Model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Employee_ID")
    private Long id;

    @Column(name = "Employee_Name")
    private String name;

    @Column(name = "Employee_age")
    private String age;

    @Column(name = "Employee_phone")
    private String phone;

    @NotEmpty
    @Email
    @Column(name = "Employee_Email")
    private String email;

    @Column(name = "Employee_address")
    private String address;

    @Column(name = "Employee_designation")
    private String designation;

    @Column(name = "Employee_Salary")
    private double salary;

    //@JsonBackReference
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Project> projects;

    @JsonIgnore
    @ManyToOne
    private Department department;


}
