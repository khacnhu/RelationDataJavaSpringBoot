package com.example.RelationDataSpringBootJava.Controller;


import com.example.RelationDataSpringBootJava.DTO.PaperDto;
import com.example.RelationDataSpringBootJava.EntityOneToMany.Paper;
import com.example.RelationDataSpringBootJava.EntityOneToOne.Address;
import com.example.RelationDataSpringBootJava.Repository.BookRepository;
import com.example.RelationDataSpringBootJava.Repository.PaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/paper")
public class PaperController {

    @Autowired
    private PaperRepository paperRepository;

    @Autowired
    private BookRepository bookRepository;


    @GetMapping
    public List<Paper> getAllPaper() {
        return paperRepository.findAll();
    }

    @GetMapping("/{id}")
    public Paper getDetailPaper(@PathVariable Integer id) {
        return paperRepository.findById(id).orElse(null);
    }

    @PostMapping
    public ResponseEntity<Paper> createUser(@RequestBody Paper paper) {
        paperRepository.save(paper);

        return ResponseEntity.ok().build();
    }


}
