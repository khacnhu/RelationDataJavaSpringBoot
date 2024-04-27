package com.example.RelationDataSpringBootJava.Controller;


import com.example.RelationDataSpringBootJava.DTO.StudentDto;
import com.example.RelationDataSpringBootJava.EntityManyToMany.Course;
import com.example.RelationDataSpringBootJava.EntityManyToMany.Student;
import com.example.RelationDataSpringBootJava.Repository.CourseRepository;
import com.example.RelationDataSpringBootJava.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired private StudentRepository studentRepository;
    @Autowired private CourseRepository courseRepository;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Student> createUser(@RequestBody StudentDto studentDto) {

        Student student = new Student();
        student.setUsername(studentDto.getUsername());
        student.setAge(studentDto.getAge());

        for (Course course : studentDto.getCourses()) {
                Course courseInDatabase = courseRepository.customQueryMethod(course.getSubject());
                if (courseInDatabase != null) {
                    student.addCourse(courseInDatabase);
                } else {
                    Course courseNew = new Course();
                    courseNew.setSubject(course.getSubject());
                    student.addCourse(courseNew);
                    courseRepository.save(courseNew);
                }
        }

        studentRepository.save(student);
        return ResponseEntity.ok().build();
    }

}
