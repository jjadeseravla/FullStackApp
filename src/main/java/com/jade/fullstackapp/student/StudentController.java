package com.jade.fullstackapp.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

//return to the client a list of students in JSON
@RestController
@RequestMapping("students") //tells port its localhost:8080/student
public class StudentController {

    @GetMapping
    public List<StudentModel> getAllStudents() {
        return Arrays.asList(
                new StudentModel(UUID.randomUUID(),
                        "Jade",
                        "Alvares",
                        "ja@gmail.com",
                        StudentModel.Gender.FEMALE),
                new StudentModel(UUID.randomUUID(),
                        "Liam",
                        "Tate",
                        "lt@gmail.com",
                        StudentModel.Gender.MALE)
        );
    }

}
