package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
/*
/create?email=[email]&name=[name]: create a new user with an auto-generated id and email and name as passed values.
/delete?id=[id]: delete the user with the passed id.
/get-by-email?email=[email]: retrieve the id for the user with the given email address.
/update?id=[id]&email=[email]&name=[name]: update the email and the name for the user identified by the given id.
*/