package com.example.CustomerManagement;

import com.example.CustomerManagement.pojo.Employee;
import com.example.CustomerManagement.repository.EmployeeRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
public class DataCreator {

    @Autowired
    private EmployeeRepo repo;

    public void createData() {
        Employee product1 = new Employee(101, "password");

        repo.save(product1);
    }
}
