package com.example.MySQL.Student;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

        private final StudentService studentService;

        public StudentController(StudentService studentService) {
                this.studentService = studentService;
        }

        @GetMapping
        public List<Student> getStudents() {
                return studentService.getStudents();

        }

        @PostMapping
        public void registerNewStudent(@RequestBody Student student) {
                studentService.addNewStudent(student);
        }

        @DeleteMapping(path = "{studentId}")
        public void deleteStudent(@PathVariable("studentId") Long studentID) {
                studentService.deleteStudent(studentID);
        }

        @PutMapping(path = "{studentId}") //update name and email
        public void updateStudent(
                @PathVariable("studentId") Long studentid,
                                  @RequestParam(required = false) String name,
                                  @RequestParam(required = false) String email) {
                studentService.updateStudent(studentid, name, email);
        }
}
