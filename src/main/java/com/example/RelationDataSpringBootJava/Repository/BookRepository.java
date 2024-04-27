package com.example.RelationDataSpringBootJava.Repository;

import com.example.RelationDataSpringBootJava.EntityOneToMany.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
