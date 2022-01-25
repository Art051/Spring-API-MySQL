package com.example.MySQL.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner( StudentRepository repository){
        return args -> {
            Student aPerson = new Student(
                    1L,
                    "aPerson",
                    "example.email@address.com",
                    LocalDate.of(2000, Month.FEBRUARY, 5)

            );

            Student anotherPerson = new Student(
                    2L,
                    "anotherPerson",
                    "anotherPerson.email@address.com",
                    LocalDate.of(2004, Month.JANUARY, 5)

            );
            repository.saveAll(
                    List.of(aPerson,anotherPerson)
            );

        };
    }

}
