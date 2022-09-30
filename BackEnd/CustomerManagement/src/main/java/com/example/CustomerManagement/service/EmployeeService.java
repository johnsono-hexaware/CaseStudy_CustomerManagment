package com.example.CustomerManagement.service;

import com.example.CustomerManagement.pojo.*;
import com.example.CustomerManagement.repository.CustomerRepo;
import com.example.CustomerManagement.repository.DependentRepo;
import com.example.CustomerManagement.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    DependentRepo dependentRepo;

    public boolean verifyLogin(int id, String password) {
        Employee emp = employeeRepo.findById(id);

        if (emp == null)
            return false;
        if (password.equals(emp.getPassword()))
            return true;
        else
            return false;
    }

    public void registerCustomer(Customer customer, List<Dependent> dependents) {

        customerRepo.save(customer);
        registerDependents(customer.getCustomerId(), dependents);
    }


    public void registerDependents(int id, List<Dependent> dependents) {
        for (Dependent d : dependents) {
            if (d.getName().equals("") || d.getName() == null)
                continue;
            d.setCustomerId(id);
            dependentRepo.save(d);
        }
    }

    public List<CustomerWithDependents> getCustomers() {
        List<CustomerWithDependents> cwdList = new ArrayList<>();

        List<Dependent> dependentList = getDependentsList();
        List<Customer> customerList = getCustomerList();
        for (Customer c : customerList) {
            if (dependentList.isEmpty()) {
                addCustomerWithoutDependent(c, cwdList);
                continue;
            }
            for (Dependent d : dependentList) {
                if (c.getCustomerId() == d.getCustomerId())
                    addCustomerWithDependent(c, d, cwdList);
                else
                    addCustomerWithoutDependent(c, cwdList);
            }
        }

        return cwdList;
    }

    private boolean customerExists(int cusId, List<CustomerWithDependents> cwdList) {
         return cwdList.stream().anyMatch(o -> cusId == o.getCustomerId());
    }

    public CustomerWithDependents findById(List<CustomerWithDependents> cwdList, int id) {
        return cwdList.stream().filter(c -> id==c.getCustomerId()).findFirst().orElse(null);
    }

    private void addCustomerWithDependent(Customer c, Dependent d, List<CustomerWithDependents> cwdList) {

        if (customerExists(c.getCustomerId(), cwdList)) {
            CustomerWithDependents cwd = findById(cwdList, c.getCustomerId());
            cwd.getDependents().add(d);
            return;
        }

        CustomerWithDependents cwd = new CustomerWithDependents(c);
        cwd.getDependents().add(d);
        cwdList.add(cwd);
        return;
    }

    private void addCustomerWithoutDependent(Customer c, List<CustomerWithDependents> cwdList) {

        if (customerExists(c.getCustomerId(), cwdList)) {
            return;
        }

        CustomerWithDependents cwd = new CustomerWithDependents(c);
        cwdList.add(cwd);
        return;
    }

    private List<Customer> getCustomerList() {
        return customerRepo.findAll();
    }
    private List<Dependent> getDependentsList() {
        return dependentRepo.findAll();
    }
}
