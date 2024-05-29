package com.employee.employeeAPI.Repository;



import com.employee.employeeAPI.Model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.LIST;

@DataJpaTest
//@AutoConfigureTestDatabase(connection= EmbeddedDatabaseConnection.H2, replace = AutoConfigureTestDatabase.Replace.ANY)
public class EmployeeRepoTest {

    @Autowired
    EmployeeRepo employeeRepo;

    //Success
    @Test
    public void testFindByEmail_Success(){
        //Given
        Employee employee = Employee.builder()
                .name("Sanjay").age("20").email("Sanjay@gmail.com")
                .phone("1212121212").address("UP").designation("SE")
                .salary(2020.0)
                .build();
        employeeRepo.save(employee);

        //When
        Employee employee1 = employeeRepo.findByEmail("Sanjay@gmail.com");

        //Then
        assertThat(employee1).isNotNull();
        assertThat(employee1.getName()).isEqualTo("Sanjay");
        assertThat(employee1.getAge()).isEqualTo("20");
        assertThat(employee1.getDesignation()).isEqualTo("SE");
        assertThat(employee1.getPhone()).isEqualTo("1212121212");
        assertThat(employee1.getAddress()).isEqualTo("UP");
        assertThat(employee1.getSalary()).isEqualTo(2020.0);

    }

    //FAILURE
    @Test
    public void testFindByEmail_Failure(){

        // Given
        Employee employee = Employee.builder()
                .name("Sanjay").age("20").email("Sanjay@gmail.com")
                .phone("1212121212").address("UP").designation("SE")
                .salary(2020.0)
                .build();
        employeeRepo.save(employee);

        //When
        Employee employee1 = employeeRepo.findByEmail("Saay@gmail.com");

        //Then
        assertThat(employee1).isNull();
    }

    @Test
    public void testfindSalaryMoreThen_success(){
        Employee employee1 = Employee.builder()
                .name("Sanjay").age("20").email("Sanjay@gmail.com")
                .phone("1212121212").address("UP").designation("SE")
                .salary(200.0)
                .build();
        Employee employee2 = Employee.builder()
                .name("Ajay").age("20").email("Sanjay@gmail.com")
                .phone("1212121212").address("UP").designation("SE")
                .salary(300.0)
                .build();
        Employee employee3 = Employee.builder()
                .name("Uday").age("20").email("Sanjay@gmail.com")
                .phone("1212121212").address("UP").designation("SE")
                .salary(400.0)
                .build();

        employeeRepo.save(employee1);
        employeeRepo.save(employee2);
        employeeRepo.save(employee3);

        List<Employee> listEmployee = employeeRepo.findSalaryMoreThen(200.0);

        assertThat(listEmployee).isNotNull();
        assertThat(listEmployee).extracting(Employee::getName).contains("Ajay","Uday");

    }



}
