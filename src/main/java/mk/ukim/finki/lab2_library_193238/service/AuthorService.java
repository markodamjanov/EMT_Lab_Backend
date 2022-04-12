package mk.ukim.finki.lab2_library_193238.service;

import mk.ukim.finki.lab2_library_193238.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findAll();

    Author findById(Long id);

    Author create(Author author);
}
