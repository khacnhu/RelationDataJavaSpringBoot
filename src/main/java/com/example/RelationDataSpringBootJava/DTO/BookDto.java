package com.example.RelationDataSpringBootJava.DTO;

import com.example.RelationDataSpringBootJava.EntityOneToMany.Paper;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
public class BookDto {

    private String author;
    private String title;
    private List<Paper> papers;

}
