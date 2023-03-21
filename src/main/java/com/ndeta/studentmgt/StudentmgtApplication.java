package com.ndeta.studentmgt;

import com.ndeta.studentmgt.entity.Student;
import com.ndeta.studentmgt.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@SpringBootApplication
@Service
public class StudentmgtApplication implements CommandLineRunner {
    @Autowired
    StudentRepository studentRepository;
    public static void main(String[] args) {
        SpringApplication.run(StudentmgtApplication.class, args);
    }
    //Implementing commandLine runner so that we can use it to auto create students
    //each time we run our app, and this will make it easy to work with the Grades
    //Section of the app
    @Override
    public void run(String... args) throws Exception {
        Student[] students = new Student[]{
                new Student( "Harry Potter", LocalDate.parse(("1980-07-31"))),
                new Student( "Ron Weasley", LocalDate.parse(("1980-03-01"))),
                new Student( "Hermione Granger", LocalDate.parse(("1979-09-19"))),
                new Student( "Neville Longbottom", LocalDate.parse(("1980-07-30")))
        };
        for (int i = 0; i <students.length; i++) {
            studentRepository.save(students[i]);
        }
    }
}
