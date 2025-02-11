package fr.epita.assistants.data.model;

import jakarta.persistence.*;

import java.util.List;

@Entity @Table(name = "course_model")
public class CourseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(nullable = false)
    public String name;

    @OneToMany
    List<StudentModel> student_list;

    @ElementCollection @CollectionTable(name = "course_model_tags") List<String> tag;
}
