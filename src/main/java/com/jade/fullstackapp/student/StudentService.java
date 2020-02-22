package com.jade.fullstackapp.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentDataAccessService studentDataAccessService;

    @Autowired
    public StudentService(StudentDataAccessService studentDataAccessService) {
        this.studentDataAccessService = studentDataAccessService;
    }

    List<StudentModel> getAllStudents() {
        return studentDataAccessService.selectAllStudents();
    }



    void addNewStudent(StudentModel student) {
        addNewStudent(null, student);
    }

    void addNewStudent(UUID studentId, StudentModel student) {
        //if student id is null we want to generate one
        UUID newStudentId = Optional.ofNullable(studentId)
                .orElse(UUID.randomUUID());

        // TODO: verify email not taken

        studentDataAccessService.insertStudent(newStudentId, student);
    }
}
