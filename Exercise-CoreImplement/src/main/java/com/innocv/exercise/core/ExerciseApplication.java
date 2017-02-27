package com.innocv.exercise.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.innocv.exercise.core.ExerciseApplication;

@SpringBootApplication
@ComponentScan(basePackages="com.innocv")
public class ExerciseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExerciseApplication.class, args);
	}
}
