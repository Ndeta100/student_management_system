package com.ndeta.studentmgt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  long id;
    @Column(name = "subject",nullable = false)
    @NonNull
    private String subject;
    @Column(name = "code",nullable = false)
    @NonNull
    private String code;
    @Column(name = "description", nullable = false,unique = true)
    @NonNull
    private String description;
    @JsonIgnore
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Grade> grades;
    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "course_student"
            ,joinColumns =@JoinColumn(name = "course_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "student_id",referencedColumnName = "id")
    )
    private Set<Student> students;

}
