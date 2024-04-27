package com.example.RelationDataSpringBootJava.Controller;


import com.example.RelationDataSpringBootJava.DTO.BookDto;
import com.example.RelationDataSpringBootJava.EntityOneToMany.Book;
import com.example.RelationDataSpringBootJava.EntityOneToMany.Paper;
import com.example.RelationDataSpringBootJava.Repository.BookRepository;
import com.example.RelationDataSpringBootJava.Repository.PaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    @Autowired
    private PaperRepository paperRepository;

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Book getDetailBook(@PathVariable Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody BookDto bookDto) {
        Book book = new Book();
        book.setAuthor(bookDto.getAuthor());
        book.setTitle(bookDto.getTitle());
        bookRepository.save(book);


        for (int i = 0; i < bookDto.getPapers().size(); i++) {
            Paper paper = new Paper();
            paper.setContent(bookDto.getPapers().get(i).getContent());
            paper.setLanguage(bookDto.getPapers().get(i).getLanguage());
            paper.setBook(book);
            paperRepository.save(paper);
        }

        return ResponseEntity.ok().build();
    }
}
