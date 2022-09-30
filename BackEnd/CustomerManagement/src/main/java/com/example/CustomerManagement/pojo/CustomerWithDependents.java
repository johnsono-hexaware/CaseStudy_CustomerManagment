package com.example.CustomerManagement.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
public class CustomerWithDependents extends Customer {

    private List<Dependent> dependents = new ArrayList<>();

    public CustomerWithDependents(Customer c) {
        this.CustomerId = c.getCustomerId();
        this.address = c.getAddress();
        this.email = c.getEmail();
        this.name = c.getName();
        this.phonenumber = c.getPhonenumber();
    }
}
