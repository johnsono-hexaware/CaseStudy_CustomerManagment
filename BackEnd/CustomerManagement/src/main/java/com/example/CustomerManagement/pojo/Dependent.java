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
@NoArgsConstructor
@AllArgsConstructor
public class Dependent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String name;
    int age;
    int customerId;
}

