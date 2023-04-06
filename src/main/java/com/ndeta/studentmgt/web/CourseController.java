package com.ndeta.studentmgt.web;


import com.ndeta.studentmgt.entity.Course;
import com.ndeta.studentmgt.entity.Student;
import com.ndeta.studentmgt.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/course")
public class CourseController {
   CourseService courseService;
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable Long id){
        return  new ResponseEntity<>(courseService.getCourse(id),HttpStatus.OK);
    }
     @PostMapping
    public ResponseEntity<Course> saveCourse(@RequestBody Course course){
        return new ResponseEntity<>(courseService.saveCourse(course), HttpStatus.CREATED);
     }
     @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }
     @GetMapping("/all")
    public ResponseEntity<List<Course>>getCourses(){
        return  new ResponseEntity<>(courseService.getCourses(),HttpStatus.OK);
     }
     @PutMapping("/{courseId}/student/{studentId}")
    public ResponseEntity<Course>enrollStudentToCourse(@PathVariable Long studentId,
                                                        @PathVariable Long courseId){
        return new ResponseEntity<>(courseService.addStudentToCourse(studentId,courseId),HttpStatus.OK);
     }
     @GetMapping("/{id}/students")
    public ResponseEntity<Set<Student>> getEnrolledStudents(@PathVariable Long id){
        return new ResponseEntity<>(courseService.getEnrolledStudents(id),HttpStatus.OK);
     }
}
