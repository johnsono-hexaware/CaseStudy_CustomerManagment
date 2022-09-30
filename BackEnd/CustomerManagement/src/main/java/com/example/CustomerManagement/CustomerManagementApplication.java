package com.example.CustomerManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.CustomerManagement")
public class CustomerManagementApplication implements CommandLineRunner {

	@Autowired
	private DataCreator dataCreator;

	public static void main(String[] args) {

		SpringApplication.run(CustomerManagementApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception
	{
		dataCreator.createData();
	}
}
