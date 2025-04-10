package org.example.library.repository;

import org.example.library.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface BookRepository extends CrudRepository<Book, Long>, FilterBookRepository {

}
