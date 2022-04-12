package mk.ukim.finki.lab2_library_193238.service;

import mk.ukim.finki.lab2_library_193238.model.Author;
import mk.ukim.finki.lab2_library_193238.model.Book;
import mk.ukim.finki.lab2_library_193238.model.DTO.BookDTO;
import mk.ukim.finki.lab2_library_193238.model.enumerations.Category;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> saveFromDto(BookDTO bookDTO);

    Book create(String name, Category category, Long authorId, Integer availableCopies);

    Optional<Book> editBook(Long id, BookDTO bookDTO);

    Optional<Book> deleteBook(Long id);

    Optional<Book> markAsTaken(Long id);
}
