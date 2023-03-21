package com.ndeta.studentmgt.service;

import com.ndeta.studentmgt.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface CourseService {
Course getCourse(Long id);
Course saveCourse(Course course);
void deleteCourse(Long id);
List<Course> getCourses();
}
