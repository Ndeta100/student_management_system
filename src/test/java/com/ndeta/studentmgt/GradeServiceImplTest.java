package com.ndeta.studentmgt;

import com.ndeta.studentmgt.entity.Course;
import com.ndeta.studentmgt.entity.Grade;
import com.ndeta.studentmgt.entity.Student;
import com.ndeta.studentmgt.exception.GradeNotFoundException;
import com.ndeta.studentmgt.repository.CourseRepository;
import com.ndeta.studentmgt.repository.GradeRepository;
import com.ndeta.studentmgt.repository.StudentRepository;
import com.ndeta.studentmgt.service.GradeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.Optional;

public class GradeServiceImplTest {
    @Mock
    GradeRepository gradeRepository;
    @Mock
    StudentRepository studentRepository;
    @Mock
    CourseRepository courseRepository;

    @InjectMocks
    GradeServiceImpl gradeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetGrade() {
        Long studentId = 1L;
        Long courseId = 2L;
        Grade expectedGrade = new Grade();
        expectedGrade.setId(1L);
        expectedGrade.setScore("A");
        expectedGrade.setStudent(new Student());
        expectedGrade.setCourse(new Course());

        Mockito.when(gradeRepository.findByStudentIdAndCourseId(studentId, courseId))
                .thenReturn(Optional.of(expectedGrade));

        Grade actualGrade = gradeService.getGrade(studentId, courseId);

        Assertions.assertEquals(expectedGrade, actualGrade);
    }
    @Test
    public void testGetGradeThrowsGradeNotFoundException() {
        Long studentId = 1L;
        Long courseId = 2L;

        Mockito.when(gradeRepository.findByStudentIdAndCourseId(studentId, courseId))
                .thenReturn(Optional.empty());

        Assertions.assertThrows(GradeNotFoundException.class,
                () -> gradeService.getGrade(studentId, courseId));
    }

    @Test
    public void testSaveGrade() {
        Long studentId = 1L;
        Long courseId = 2L;
        Grade expectedGrade = new Grade();
        expectedGrade.setId(1L);
        expectedGrade.setScore("A");
        expectedGrade.setStudent(new Student());
        expectedGrade.setCourse(new Course());

        Mockito.when(studentRepository.findById(studentId))
                .thenReturn(Optional.of(new Student()));
        Mockito.when(courseRepository.findById(courseId))
                .thenReturn(Optional.of(new Course()));
        Mockito.when(gradeRepository.save(Mockito.any(Grade.class)))
                .thenReturn(expectedGrade);

        Grade actualGrade = gradeService.saveGrade(new Grade(), studentId, courseId);

        Assertions.assertEquals(expectedGrade, actualGrade);
    }
    @Test
    public void testUpdateGrade() {
        Long studentId = 1L;
        Long courseId = 2L;
        String newScore = "B";
        Grade expectedGrade = new Grade();
        expectedGrade.setId(1L);
        expectedGrade.setScore(newScore);
        expectedGrade.setStudent(new Student());
        expectedGrade.setCourse(new Course());

        Mockito.when(gradeRepository.findByStudentIdAndCourseId(studentId, courseId))
                .thenReturn(Optional.of(expectedGrade));
        Mockito.when(gradeRepository.save(Mockito.any(Grade.class)))
                .thenReturn(expectedGrade);

        Grade actualGrade = gradeService.updateGrade(newScore, studentId, courseId);

        Assertions.assertEquals(expectedGrade, actualGrade);
    }

}
