package com.neosoft.task2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.neosoft.task2.model.User;

@SpringBootApplication
public class SpringbootApplication1Application {

	public static void main(String[] args) {
		
		System.out.println("hi");
		SpringApplication.run(SpringbootApplication1Application.class, args);
		
		/*
		 * User u=new User(); u.setId(1);
		 * 
		 * System.out.println(u.getId());
		 */
	}

}
