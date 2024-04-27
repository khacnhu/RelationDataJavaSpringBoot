package com.example.RelationDataSpringBootJava.Repository;


import com.example.RelationDataSpringBootJava.EntityManyToMany.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    @Query("SELECT c from Course c WHERE c.subject LIKE %:subject%")
    Course customQueryMethod(@Param(value = "subject") String subject);
}
