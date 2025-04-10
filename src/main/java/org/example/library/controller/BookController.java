package org.example.library.controller;

import lombok.RequiredArgsConstructor;
import org.example.library.dto.BookFilter;
import org.example.library.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookRepository bookRepository;
    @GetMapping
    public String getAllBooks(Model model,
                              BookFilter bookFilter,
                              @RequestParam(defaultValue = "1") int page,
                              @RequestParam(defaultValue = "5") int size) {
        model.addAttribute("books", bookRepository.findAllByFilter(bookFilter, page - 1, size));
        model.addAttribute("page", page);
        model.addAttribute("size", size);
        return "hello";
    }
}
