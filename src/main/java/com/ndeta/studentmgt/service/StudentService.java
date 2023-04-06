package com.ndeta.studentmgt.service;

import com.ndeta.studentmgt.entity.Course;
import com.ndeta.studentmgt.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface StudentService {
    Student getStudent(Long id);
    Student saveStudent(Student student);
    void deleteStudent(Long id);
    List<Student> getStudents();
    Set<Course> getEnrolledCourses(Long id);
}
