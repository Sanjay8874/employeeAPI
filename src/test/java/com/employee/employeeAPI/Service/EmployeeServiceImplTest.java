package com.employee.employeeAPI.Service;

import com.employee.employeeAPI.Model.Employee;
import com.employee.employeeAPI.Repository.EmployeeRepo;
import com.employee.employeeAPI.Service.EmployeeService.EmployeeServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceImplTest {

    @Mock
    EmployeeRepo employeeRepo;

    @InjectMocks
    EmployeeServiceImpl employeeService;

    Employee employee1;
    Employee employee2;

    @BeforeEach
    void setUp() {
        employee1 = Employee.builder()
                .name("Sanjay").age("20").email("Sanjay@gmail.com")
                .phone("1212121212").address("UP").designation("SE")
                .salary(2020.0)
                .build();

        employee1 = Employee.builder()
                .name("Ajay").age("21").email("Ajay@gmail.com")
                .phone("1212121200").address("UP1").designation("SE1")
                .salary(2000.0)
                .build();
    }

    @Test
    public void testEmployeeService(){

        //when
        when(employeeRepo.findByEmail(employee1.getEmail())).thenReturn(employee1);



    }
}
