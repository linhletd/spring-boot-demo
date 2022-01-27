package com.example.demo;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.student.Student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@GetMapping("/hello")
	public List<Student> hello(){
		Student std = new Student(1L, "linh", 29, LocalDate.of(1993, 1, 18), "linhletd@gmail.com");
		return List.of(std);
	}

}
