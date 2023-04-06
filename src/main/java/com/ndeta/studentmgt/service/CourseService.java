package com.ndeta.studentmgt.service;

import com.ndeta.studentmgt.entity.Course;
import com.ndeta.studentmgt.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service

public interface CourseService {
Course getCourse(Long id);
Course saveCourse(Course course);
void deleteCourse(Long id);
List<Course> getCourses();
public Course addStudentToCourse(Long studentId, Long courseId);
public Set<Student> getEnrolledStudents(Long id);
}
