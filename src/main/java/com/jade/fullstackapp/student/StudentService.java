package com.jade.fullstackapp.student;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

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
