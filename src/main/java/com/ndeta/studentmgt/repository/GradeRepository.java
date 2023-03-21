package com.ndeta.studentmgt.repository;

import com.ndeta.studentmgt.entity.Grade;
import org.springframework.data.repository.CrudRepository;

public interface GradeRepository extends CrudRepository<Grade, Long> {
    Grade findByStudentId(Long studentId);
}
