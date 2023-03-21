package com.ndeta.studentmgt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "student")
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Long id;
    @Column(name = "name" ,nullable = false)
    @NonNull
    private String name;
    @Column(name = "birth_date",nullable = false)
    @NonNull
    private LocalDate birthDate;

    @JsonIgnore
    @OneToMany(mappedBy = "student",cascade =CascadeType.ALL )
    private List<Grade>grades;
}
