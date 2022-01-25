package com.example.MySQL.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository
        extends JpaRepository<Student, Long> {

    //SELECT * FROM student WHERE email = ?
    //("SELECT s FROM Student s WHERE s.email = ?1")

    @Query
    Optional<Student> findStudentByEmail(String email);

    @Query
    Optional<Student> findStudentById(Long id);
}
