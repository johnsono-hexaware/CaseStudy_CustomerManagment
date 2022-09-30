package com.example.CustomerManagement.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    //String name;
    String password;

    Employee() {}
    public Employee(int id, String password)
    {
        this.id = id;
        //this.name = name;
        this.password = password;
    }
}
