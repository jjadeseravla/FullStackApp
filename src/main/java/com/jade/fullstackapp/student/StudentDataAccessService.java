package com.jade.fullstackapp.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository
public class StudentDataAccessService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired //spring automatically instantiates the jdbc template
    //so you can use whatever you want
    public StudentDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    //this class allows us to connect to our db

    List<StudentModel> selectAllStudents() {
        String sql = "" +
                "SELECT " +
                " student_id, " +
                " first_name, " +
                " second_name, " +
                " email, " +
                " gender " +
                "FROM student";

        return jdbcTemplate.query(sql, mapStudentFromDB());
    }

    private RowMapper<StudentModel> mapStudentFromDB() {
        return (resultSet, i) -> { //want a jdbctemplate method that takes an sql statement and roadmapper
            //the resultset is what we take as raw data and transform into a student
            //converting data from DB to a java object

            //grab contents of each column with resultset
            String studentIdStr = resultSet.getString("student_id");
            UUID studentId = UUID.fromString(studentIdStr);

            String firstName = resultSet.getString("first_name");
            String secondName = resultSet.getString("second_name");
            String email = resultSet.getString("email");
            String genderStr = resultSet.getString("gender").toUpperCase();
            StudentModel.Gender gender = StudentModel.Gender.valueOf(genderStr);

            return new StudentModel(
                    studentId,
                    firstName,
                    secondName,
                    email,
                    gender
            );
        };
    }

    public int insertStudent(UUID newStudentId, StudentModel student) {
        return 0;
    }
}
