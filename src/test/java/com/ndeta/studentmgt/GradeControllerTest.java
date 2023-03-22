package com.ndeta.studentmgt;
import com.ndeta.studentmgt.entity.Grade;
import com.ndeta.studentmgt.service.GradeService;
import com.ndeta.studentmgt.web.GradeController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GradeControllerTest {
    @InjectMocks
    GradeController gradeController;

    @Mock
    GradeService gradeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetGrade() {
        Long studentId = 1L;
        Long courseId = 2L;
        Grade grade = new Grade();
        when(gradeService.getGrade(studentId, courseId)).thenReturn(grade);

        ResponseEntity<Grade> response = gradeController.getGrade(studentId, courseId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(grade, response.getBody());
        verify(gradeService, times(1)).getGrade(studentId, courseId);
    }
    @Test
    void testSaveGrade() {
        Long studentId = 1L;
        Long courseId = 2L;
        Grade grade = new Grade();
        when(gradeService.saveGrade(grade, studentId, courseId)).thenReturn(grade);

        ResponseEntity<Grade> response = gradeController.saveGrade(grade, studentId, courseId);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(grade, response.getBody());
        verify(gradeService, times(1)).saveGrade(grade, studentId, courseId);
    }

    @Test
    void testDeleteGrade() {
        Long studentId = 1L;
        Long courseId = 2L;

        ResponseEntity<HttpStatus> response = gradeController.deleteGrade(studentId, courseId);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(gradeService, times(1)).deleteGrade(studentId, courseId);
    }
    @Test
    void testGetStudentGrades() {
        Long studentId = 1L;
        List<Grade> grades = new ArrayList<>();
        grades.add(new Grade());
        grades.add(new Grade());
        when(gradeService.getStudentGrades(studentId)).thenReturn(grades);

        ResponseEntity<List<Grade>> response = gradeController.getStudentGrades(studentId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(grades, response.getBody());
        verify(gradeService, times(1)).getStudentGrades(studentId);
    }
}
