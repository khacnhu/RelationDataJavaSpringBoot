package com.example.RelationDataSpringBootJava.Repository;

import com.example.RelationDataSpringBootJava.EntityOneToMany.Paper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaperRepository extends JpaRepository<Paper, Integer> {
}

