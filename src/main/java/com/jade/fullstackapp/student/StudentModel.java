package com.jade.fullstackapp.student;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;


public class StudentModel {

    private final UUID studentId;

    @NotBlank //must not be null
    private final String firstName;

    @NotBlank
    private final String secondName;

    @Email
    private final String email;

    @NotNull
    private final Gender gender;

    //receive a JSON payload, and then i Want to map all the JSON properties i get from the client
    //to the strings in brackets so i can have an instance of the studentmodel class in the
    //student controller
    public StudentModel(@JsonProperty("studentId") UUID studentId,
                        @JsonProperty("firstName")String firstName,
                        @JsonProperty("secondName")String secondName,
                        @JsonProperty("email")String email,
                        @JsonProperty("gender")Gender gender) {
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

    @Override
    public String toString() {
        //press control enter to get the option of making a toString method
        return "StudentModel{" +
                "studentId=" + studentId +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                '}';
    }

    enum Gender {
        MALE, FEMALE
    }
}
