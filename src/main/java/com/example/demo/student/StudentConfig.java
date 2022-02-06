package com.example.demo.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
  @Bean
  CommandLineRunner commandLineRunner(StudentRepository studentRepository){
    return args->{
      Student linh = new Student("linh", LocalDate.of(1993, 1, 18), "linhletd@gmail.com");
      Student giang = new Student("giang", LocalDate.of(1994, 10, 3), "giangle@gmail.com");
      studentRepository.saveAll(List.of(linh, giang));

    };
  }
  
}
