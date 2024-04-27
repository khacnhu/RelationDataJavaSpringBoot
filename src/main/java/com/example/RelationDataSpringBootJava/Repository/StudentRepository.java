package com.example.RelationDataSpringBootJava.Repository;

import com.example.RelationDataSpringBootJava.EntityManyToMany.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
