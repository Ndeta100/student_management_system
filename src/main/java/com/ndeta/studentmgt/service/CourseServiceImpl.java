package com.ndeta.studentmgt.service;

import com.ndeta.studentmgt.entity.Course;
import com.ndeta.studentmgt.exception.CourseNotFoundException;
import com.ndeta.studentmgt.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CourseServiceImpl implements CourseService{
 CourseRepository courseRepository;
    @Override
    public Course getCourse(Long id) {
        Optional<Course> course=courseRepository.findById(id);
        if (course.isPresent()){
            return course.get();
        }else {
            throw new CourseNotFoundException(id);
        }
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public List<Course> getCourses() {
        return (List<Course>) courseRepository.findAll();
    }
    //Reusable method
    static Course unwrapCourse(Optional<Course> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new CourseNotFoundException(id);
    }

}
