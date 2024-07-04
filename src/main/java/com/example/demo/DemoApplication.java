package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

//	@Autowired
//	JavaBeansUsingAnnotation obj1;
//
//	@Autowired
//	JavaBeansUsingAnnotation obj2;


	@Autowired
	DBService DB;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
//		JavaBeansUsingAnnotation obj =new JavaBeansUsingAnnotation();
//		obj.message();
		//obj.message();   -->> this will give reference error
	}

	@Override
	public void run(String... args) throws Exception {
//		obj1.message1();
//		System.out.println(obj1.hashCode());
//
//		obj2.message2();
//		System.out.println(obj2.hashCode());

		System.out.println(DB.getData());




	}
}
