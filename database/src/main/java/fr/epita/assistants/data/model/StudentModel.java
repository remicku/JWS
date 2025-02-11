package fr.epita.assistants.data.model;

import jakarta.persistence.*;

@Entity @Table(name = "student_model")
public class StudentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(nullable = false)
    String name;

    @ManyToOne
    @JoinColumn(name = "course_id")
    CourseModel course_id;

}
