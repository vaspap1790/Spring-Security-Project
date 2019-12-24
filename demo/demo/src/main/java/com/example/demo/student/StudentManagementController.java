package com.example.demo.student;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {


    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "James Joyce"),
            new Student(2, "Mairy Poppins"),
            new Student(3, "Anna Smith")
    );

    @GetMapping
    public List<Student> getAllStudents(){
        return STUDENTS;
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        System.out.println(student + " registered");
    }

    @DeleteMapping(path="{studentId}")
    public void deleteStudent(@PathVariable("studentId") Integer studentId){
        System.out.println(studentId + "Student deleted");
    }

    @PutMapping(path="{studentId}")
    public void update(@PathVariable("studentId") Integer studentId, @RequestBody Student student){
        System.out.println(String.format("Updated %s,%s",studentId,student));
    }
}
