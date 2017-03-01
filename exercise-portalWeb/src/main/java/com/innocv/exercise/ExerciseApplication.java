package com.innocv.exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.innocv")
public class ExerciseApplication  {

	public static void main(String[] args) {
		SpringApplication.run(ExerciseApplication.class, args);
	}
}
