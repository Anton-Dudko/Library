package org.example.library.repository;

import org.example.library.dto.BookFilter;
import org.example.library.model.Book;

import java.util.List;

public interface FilterBookRepository {
    List<Book> findAllByFilter(BookFilter filter, int page, int size);
}
