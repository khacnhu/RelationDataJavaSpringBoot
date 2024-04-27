package com.example.RelationDataSpringBootJava.Controller;


import com.example.RelationDataSpringBootJava.EntityManyToMany.Course;
import com.example.RelationDataSpringBootJava.EntityManyToMany.Student;
import com.example.RelationDataSpringBootJava.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {


    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public List<Course> getAllStudents() {
        return courseRepository.findAll();
    }

}
