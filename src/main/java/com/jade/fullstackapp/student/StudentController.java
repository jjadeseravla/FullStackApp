package com.jade.fullstackapp.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

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
        //throw new ApiRequestException("Problem! Cannot get all students with custom exception");
        //throw new IllegalStateException("Problem! Cannot get all students");
        return studentService.getAllStudents();
    }

    @GetMapping(path = "{studentId}/courses")
    public List<StudentCourseModel> getAllCoursesForStudent(
        @PathVariable("studentId") UUID studentId) {
//        TODO go to DB and fetch info for a given student
//        a student can have 0 + courses.
        System.out.println(studentId);
        return null;
    }

    @PostMapping
    //get JSON payload from request body and transform it
    public void addNewStudent(@RequestBody @Valid StudentModel student) {
        System.out.println(student);
        //we could student.getFirstName() == null || student.getSecondName() == null etc
        //to check nothing is empty before have to go all the way to the server for it to give an error about
        //send an empty object. or use java bean validation by using annotations inside studentmodel to enforce
        //some constraints inside this class
        studentService.addNewStudent(student);
    }
}
