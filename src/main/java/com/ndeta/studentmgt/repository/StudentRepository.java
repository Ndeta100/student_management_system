package com.ndeta.studentmgt.repository;

import com.ndeta.studentmgt.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,Long> {
}
