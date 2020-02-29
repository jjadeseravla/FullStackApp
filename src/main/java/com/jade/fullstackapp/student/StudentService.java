package com.jade.fullstackapp.student;

import com.jade.fullstackapp.EmailValidator;
import com.jade.fullstackapp.Exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentDataAccessService studentDataAccessService;
    private final EmailValidator emailValidator;

    @Autowired
    public StudentService(StudentDataAccessService studentDataAccessService,
                          EmailValidator emailValidator) {
        this.studentDataAccessService = studentDataAccessService;
        this.emailValidator = emailValidator;
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

        // TODO: validate email(not showing up on postman message)
        if (!emailValidator.test(student.getEmail())) {
            throw new ApiRequestException(student.getEmail() + " is not valid");

        }

        if (studentDataAccessService.isEmailTaken(student.getEmail())) {
            throw new ApiRequestException(student.getEmail() + " is taken");

        }

        studentDataAccessService.insertStudent(newStudentId, student);
    }

    public List<StudentCourseModel> getAllCoursesForStudent(UUID studentId) {
        return studentDataAccessService.selectAllStudentCourses(studentId);
    }
}
