package com.ndeta.studentmgt.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
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
    @Column(name = "description", nullable = false)
    @NonNull
    private String description;

}
