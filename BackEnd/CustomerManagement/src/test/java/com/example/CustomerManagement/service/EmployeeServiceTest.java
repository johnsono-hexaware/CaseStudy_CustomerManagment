package com.example.CustomerManagement.service;

import com.example.CustomerManagement.pojo.Customer;
import com.example.CustomerManagement.pojo.CustomerWithDependents;
import com.example.CustomerManagement.pojo.Dependent;
import com.example.CustomerManagement.pojo.Employee;
import com.example.CustomerManagement.repository.CustomerRepo;
import com.example.CustomerManagement.repository.DependentRepo;
import com.example.CustomerManagement.repository.EmployeeRepo;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;

@SpringBootTest
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService = new EmployeeService();

    @MockBean
    private CustomerRepo customerRepo;
    @MockBean
    private DependentRepo dependentRepo;
    @MockBean
    private EmployeeRepo employeeRepo;

    @Test
    public void ifValidCredentialsThenLoginShouldBeSuccessful() {
        Employee validEmployee = new Employee(1000, "password");

        Mockito.when(employeeRepo.findById(validEmployee.getId()))
                .thenReturn(validEmployee);

        boolean loggedIn = employeeService.verifyLogin(validEmployee.getId(), validEmployee.getPassword());

        Assertions.assertTrue(loggedIn);
    }

    @Test
    public void ifInvalidCredentialsThenLoginShouldBeUnsuccessful() {
        Employee validEmployee = new Employee(1000, "password");

        Mockito.when(employeeRepo.findById(validEmployee.getId()))
                .thenReturn(validEmployee);

        boolean loggedIn = employeeService.verifyLogin(validEmployee.getId(), "incorrect password");

        Assertions.assertFalse(loggedIn);
    }

    @Test
    public void registeringACustomerIsSuccessful() {
        Customer customer = new Customer();
        List<Dependent> dependents = new ArrayList<>();
        Mockito.when(customerRepo.save(customer)).thenReturn(customer);
        employeeService.registerCustomer(customer, dependents);


        Mockito.verify(customerRepo, times(1)).save(customer);
    }

    @Test
    public void registeringADependentIsSuccessful() {
        List<Dependent> dependents = new ArrayList<>();
        Dependent dependent = new Dependent(5, "john", 15, 10);
        dependents.add(dependent);
        Mockito.when(dependentRepo.save(dependent)).thenReturn(dependent);
        employeeService.registerDependents(10, dependents);

        Mockito.verify(dependentRepo, times(1)).save(dependent);
    }

    @Test
    public void shouldGetListOfCustomersAndTheirDependents() {
        Customer c1 = new Customer(10, "jim", "email@gmail.com", "32432423", "123 Main St");
        Customer c2 = new Customer(20, "tim", "email2@gmail.com", "+132432423", "123 Game St");

        List<Customer> customers = new ArrayList<>();
        customers.add(c1);
        customers.add(c2);

        Dependent d1 = new Dependent(50, "john", 15, 20);
        Dependent d2 = new Dependent(60, "james", 16, 20);


        List<Dependent> dependents = new ArrayList<>();
        dependents.add(d1);
        dependents.add(d2);


        Mockito.when(customerRepo.findAll()).thenReturn(customers);
        Mockito.when(dependentRepo.findAll()).thenReturn(dependents);

        List<CustomerWithDependents> cwdListExpected = new ArrayList<>();

        CustomerWithDependents cwd1 = new CustomerWithDependents(c1);
        CustomerWithDependents cwd2 = new CustomerWithDependents(c2);
        cwd2.getDependents().add(d1);
        cwd2.getDependents().add(d2);

        cwdListExpected.add(cwd1);
        cwdListExpected.add(cwd2);

        List<CustomerWithDependents> cwdListActual = employeeService.getCustomers();

        System.out.println(cwdListActual);

        Assertions.assertEquals(cwdListExpected, cwdListActual);

    }


}
