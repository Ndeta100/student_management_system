package com.ndeta.studentmgt.service;

import com.ndeta.studentmgt.entity.Grade;
import com.ndeta.studentmgt.entity.Student;
import com.ndeta.studentmgt.repository.GradeRepository;
import com.ndeta.studentmgt.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class StudentServiceImpl implements  StudentService{

    StudentRepository studentRepository;
    GradeRepository gradeRepository;

    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getStudents() {
        return (List<Student>) studentRepository.findAll();
    }


}
