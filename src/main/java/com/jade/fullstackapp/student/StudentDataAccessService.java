package com.jade.fullstackapp.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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

    public List<StudentModel> selectAllStudents() {
        String sql = "" +
                "SELECT " +
                " student_id, " +
                " first_name, " +
                " second_name, " +
                " email, " +
                " gender " +
                "FROM student";

        List<StudentModel> students = jdbcTemplate.query(sql, (resultSet, i) -> { //want a jdbctemplate method that takes an sql statement and roadmapper
            //the resultset is what we take as raw data and transform into a student
            //converting data from DB to a java object
            return null;
        });

        return null;
    }
}
