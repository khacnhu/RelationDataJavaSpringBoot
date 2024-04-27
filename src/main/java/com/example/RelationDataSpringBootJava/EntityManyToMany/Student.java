package com.example.RelationDataSpringBootJava.EntityManyToMany;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private Integer age;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "student_course_like",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    Set<Course> likedCourses = new HashSet<Course>();

    public void addCourse(Course course) {
        this.likedCourses.add(course);
    }



}
