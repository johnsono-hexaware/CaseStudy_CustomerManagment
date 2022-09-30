package com.example.CustomerManagement.repository;

import com.example.CustomerManagement.pojo.Customer;
import com.example.CustomerManagement.pojo.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    List<Customer> findAll();
}
