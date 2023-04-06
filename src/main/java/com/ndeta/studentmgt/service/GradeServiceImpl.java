package com.ndeta.studentmgt.service;

import com.ndeta.studentmgt.entity.Course;
import com.ndeta.studentmgt.entity.Grade;
import com.ndeta.studentmgt.entity.Student;
import com.ndeta.studentmgt.exception.GradeNotFoundException;
import com.ndeta.studentmgt.exception.StudentNotEnrolledException;
import com.ndeta.studentmgt.repository.CourseRepository;
import com.ndeta.studentmgt.repository.GradeRepository;
import com.ndeta.studentmgt.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class GradeServiceImpl implements GradeService{

    GradeRepository gradeRepository;
    StudentRepository studentRepository;
    CourseRepository courseRepository;
    @Override
    public Grade getGrade(Long studentId, Long courseId) {
        Optional<Grade> grade= gradeRepository.findByStudentIdAndCourseId(studentId,courseId);
        if (grade.isPresent()){
           return grade.get();
        }else {
            throw new GradeNotFoundException(studentId,courseId);
        }
    }

    @Override
    public Grade saveGrade(Grade grade, Long studentId, Long courseId) {
        Student student=StudentServiceImpl
                .unwrapStudent(studentRepository.findById(studentId), studentId);
        Course course=CourseServiceImpl
                .unwrapCourse(courseRepository.findById(courseId), courseId);
        if(!student.getCourses()
                .contains(course)) throw new StudentNotEnrolledException(studentId,courseId);
        grade.setStudent(student);
        grade.setCourse(course);
        return gradeRepository.save(grade);
    }
//
    @Override
    public Grade updateGrade(String score, Long studentId, Long courseId) {
        Optional<Grade> grade=gradeRepository.findByStudentIdAndCourseId(studentId,courseId);
        if (grade.isPresent()){
            Grade unwarappedGrade=grade.get();
            unwarappedGrade.setScore(score);
          return gradeRepository.save(unwarappedGrade);
        }else {
            throw new GradeNotFoundException(studentId,courseId);
        }
    }

    @Override
    public void deleteGrade( Long studentId, Long courseId) {
            gradeRepository.deleteByStudentIdAndCourseId(studentId,courseId);
    }

    @Override
    public List<Grade> getStudentGrades(Long studentId) {
        return gradeRepository.findByStudentId(studentId);
    }

    @Override
    public List<Grade> getCourseGrades(Long courseId) {
        return gradeRepository.findByCourseId(courseId);
    }

    @Override
    public List<Grade> getAllGrades() {
        return (List<Grade>) gradeRepository.findAll();
    }
}
