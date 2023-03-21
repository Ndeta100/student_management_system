package com.ndeta.studentmgt.web;


import com.ndeta.studentmgt.entity.Course;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable Long id){
        return  new ResponseEntity<>(HttpStatus.OK);
    }
     @PostMapping
    public ResponseEntity<Course> saveCourse(@RequestBody Course course){
        return new ResponseEntity<>(course, HttpStatus.CREATED);
     }
     @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable Long id){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }
     @GetMapping("/all")
    public ResponseEntity<Course>getcourses(){
        return  new ResponseEntity<>(HttpStatus.OK);
     }
}
