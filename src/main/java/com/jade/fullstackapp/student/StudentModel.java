package com.jade.fullstackapp.student;

import java.util.UUID;

public class StudentModel {

    private final UUID studentId;
    private final String firstName;
    private final String secondName;
    private final String email;
    private final Gender gender;

    public StudentModel(UUID studentId,
                        String firstName,
                        String secondName,
                        String email,
                        Gender gender) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.gender = gender;
    }

    public UUID getStudentId() {
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getEmail() {
        return email;
    }

    public Gender getGender() {
        return gender;
    }


    enum Gender {
        MALE, FEMALE
    }
}
