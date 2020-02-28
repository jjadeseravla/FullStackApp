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

    int insertStudent(UUID studentId, StudentModel student) {
        String sql = "" +
                "INSERT INTO student (" +
                " student_id," +
                " first_name, " +
                " second_name, " +
                " email, " +
                " gender)" +
                "VALUES (?, ?, ?, ?, ?::gender)"; //5 as one is for studentId
//        /how we cast into a gender (the postgres enum)
        return jdbcTemplate.update( //to interact with DB use JdbcTemplate
                sql,
                studentId,
                student.getFirstName(),
                student.getSecondName(),
                student.getEmail(),
                student.getGender().name().toUpperCase()
        );
        //if update result is successful, itll be 1 or a 0
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

    @SuppressWarnings("ConstantConditions")// cos otherwise it thinks theres nothing to be returned in this method
    boolean isEmailTaken(String email) {
        String sql = "" +
                "SELECT EXISTS ( " +
                " SELECT 1 " +
                " FROM student " +
                " WHERE email = ?" +
                ")";
        return jdbcTemplate.queryForObject(
                sql,
                new Object[] {email},
                (resultSet, i) -> resultSet.getBoolean(1)
        );
    }
}
