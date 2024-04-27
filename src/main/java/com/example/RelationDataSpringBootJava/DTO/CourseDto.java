package com.example.RelationDataSpringBootJava.DTO;

import com.example.RelationDataSpringBootJava.EntityManyToMany.Course;
import com.example.RelationDataSpringBootJava.EntityManyToMany.Student;
import lombok.Data;

import java.util.Set;

@Data
public class CourseDto {

    private String subject;
    private Set<Student> students;


}
