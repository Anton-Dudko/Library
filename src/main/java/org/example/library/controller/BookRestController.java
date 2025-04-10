package org.example.library.controller;

import lombok.RequiredArgsConstructor;
import org.example.library.dto.BookRequest;
import org.example.library.repository.BookRepository;
import org.example.library.service.BookService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
public class BookRestController {

    private final BookRepository bookRepository;
    private final BookService bookService;

    @PostMapping
    public void addBook(@RequestBody BookRequest bookRequest) {
        bookService.createBook(bookRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    @PutMapping("/{id}")
    public void updateBook(@PathVariable Long id, @RequestBody BookRequest bookRequest) {
        bookService.editBook(id, bookRequest);
    }
}
