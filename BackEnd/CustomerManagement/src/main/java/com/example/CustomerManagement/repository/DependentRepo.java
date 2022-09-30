package com.example.CustomerManagement.repository;

import com.example.CustomerManagement.pojo.Dependent;
import com.example.CustomerManagement.pojo.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DependentRepo extends JpaRepository<Dependent, Integer> {
    List<Dependent> findAll();
}
