package com.example.RelationDataSpringBootJava.DTO;

import com.example.RelationDataSpringBootJava.EntityManyToMany.Course;
import lombok.Data;

import java.util.Set;

@Data
public class StudentDto {

    private String username;
    private Integer age;

    private Set<Course> courses;




}
