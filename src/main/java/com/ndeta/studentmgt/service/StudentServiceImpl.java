package com.ndeta.studentmgt.service;
import com.ndeta.studentmgt.entity.Course;
import com.ndeta.studentmgt.entity.Student;
import com.ndeta.studentmgt.exception.StudentNotFoundException;
import com.ndeta.studentmgt.repository.GradeRepository;
import com.ndeta.studentmgt.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements  StudentService{

    StudentRepository studentRepository;
    GradeRepository gradeRepository;

    @Override
    public Student getStudent(Long id) {
        Optional<Student> student=studentRepository.findById(id);
        if(student.isPresent()){
          return student.get();
        }else {
            throw new StudentNotFoundException(id);
        }
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

    @Override
    public Set<Course> getEnrolledCourses(Long id) {
        Student student=getStudent(id);
        return student.getCourses();
    }

    //Reusable method
    static Student unwrapStudent(Optional<Student> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new StudentNotFoundException(id);
    }

}
