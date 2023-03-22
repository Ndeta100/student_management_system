package com.ndeta.studentmgt;

import com.ndeta.studentmgt.entity.Course;
import com.ndeta.studentmgt.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
@DataJpaTest
@SpringBootTest
class StudentmgtApplicationTests {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    void testCreateCourse() {

    }

}
