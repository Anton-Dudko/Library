package org.example.library.service;

import lombok.RequiredArgsConstructor;
import org.example.library.dto.BookRequest;
import org.example.library.model.Book;
import org.example.library.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public void createBook(BookRequest bookRequest) {
        var book = Book.builder()
                .brand(bookRequest.getBrand())
                .title(bookRequest.getTitle())
                .price(bookRequest.getPrice())
                .stock(bookRequest.getStock())
                .publicationYear(bookRequest.getPublicationYear())
                .vendorCode(bookRequest.getVendorCode())
                .build();
        bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public void editBook(Long id, BookRequest bookRequest) {
        bookRepository.findById(id)
                .map(book -> {
                    book.setBrand(bookRequest.getBrand());
                    book.setTitle(bookRequest.getTitle());
                    book.setPrice(bookRequest.getPrice());
                    book.setStock(bookRequest.getStock());
                    book.setPublicationYear(bookRequest.getPublicationYear());
                    book.setVendorCode(bookRequest.getVendorCode());
                    return bookRepository.save(book);
                });
    }
}
