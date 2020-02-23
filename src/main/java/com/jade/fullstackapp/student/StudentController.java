package com.jade.fullstackapp.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//return to the client a list of students in JSON
@RestController
@RequestMapping("students") //tells port its localhost:8080/student
public class StudentController {

    public final StudentService studentService;

    @Autowired //dependency injection
    //grabs dependency in line 15 and injects in 19 and assigns to our private field
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentModel> getAllStudents() {
        throw new IllegalStateException("Problem! Cannot get all students");
        //return studentService.getAllStudents();
    }

    @PostMapping
    //get JSON payload from request body and transform it
    public void addNewStudent(@RequestBody StudentModel student) {
        System.out.println(student);
        studentService.addNewStudent(student);
    }
}
