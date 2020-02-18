package com.jade.fullstackapp.student;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository
public class StudentDataAccessService {

    public List<StudentModel> selectAllStudents() {
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
