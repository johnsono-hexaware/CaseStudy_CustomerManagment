package com.example.CustomerManagement.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest {
    Customer customer;
    List<Dependent> dependents;
}
