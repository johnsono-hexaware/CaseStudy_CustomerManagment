package com.example.CustomerManagement.controller;

import com.example.CustomerManagement.pojo.*;
import com.example.CustomerManagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin
//@CrossOrigin(origins = "http://localhost:3001")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Employee employee) {
        if (service.verifyLogin(employee.getId(), employee.getPassword()))
            return new ResponseEntity<>("Successfully login", HttpStatus.OK);
        else
            return new ResponseEntity<>("Invalid login credentials",
                HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/register")
    public ResponseEntity registerCustomer(@RequestBody RegistrationRequest rr) {
        service.registerCustomer(rr.getCustomer(), rr.getDependents());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/viewcustomers")
    public List<CustomerWithDependents> viewCustomers() {
        return service.getCustomers();
    }
}
