package com.ndeta.studentmgt.service;

import com.ndeta.studentmgt.entity.Student;

import java.util.List;

public interface StudentService {
    Student getStudent(Long id);
    Student saveStudent(Student student);
    void deleteStudent(Long id);
    List<Student> getStudents();
}
