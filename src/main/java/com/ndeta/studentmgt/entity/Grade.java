package com.ndeta.studentmgt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "grade")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Long id;
    @Column(name = "score", nullable = false)
    private  String score;

    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id",referencedColumnName = "id")
   private Student student;
}

