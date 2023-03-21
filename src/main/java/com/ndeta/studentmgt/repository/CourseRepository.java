package com.ndeta.studentmgt.repository;

import com.ndeta.studentmgt.entity.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
}
