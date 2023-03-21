package com.ndeta.studentmgt.service;

import com.ndeta.studentmgt.entity.Grade;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface GradeService {

    Grade getGrade(Long studentId, Long courseId);
    Grade saveGrade(Grade grade, Long studentId, Long courseId);
    Grade updateGrade(String score, Long studentId, Long courseId);
    void deleteGrade(String score, Long studentId, Long courseId);
    List<Grade> getStudentGrades(Long studentId);
    List<Grade> getCourseGrades(Long courseId);
    List<Grade> getAllGrades();
}
