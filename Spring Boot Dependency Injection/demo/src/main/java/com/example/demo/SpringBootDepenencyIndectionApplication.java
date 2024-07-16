package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class SpringBootDepenencyIndectionApplication implements CommandLineRunner {

	@Autowired
	DBService DBServiceObj;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hii");
		System.out.println(DBServiceObj.Display()) ;

	}
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDepenencyIndectionApplication.class, args);
	}





// for More DI
//  https://medium.com/@reetesh043/spring-boot-dependency-injection-137f85f84590


}
