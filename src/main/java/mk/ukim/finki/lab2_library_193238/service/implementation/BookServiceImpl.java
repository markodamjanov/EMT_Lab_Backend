package mk.ukim.finki.lab2_library_193238.service.implementation;

import mk.ukim.finki.lab2_library_193238.model.Author;
import mk.ukim.finki.lab2_library_193238.model.Book;
import mk.ukim.finki.lab2_library_193238.model.DTO.BookDTO;
import mk.ukim.finki.lab2_library_193238.model.enumerations.Category;
import mk.ukim.finki.lab2_library_193238.model.exceptions.AuthorNotFoundException;
import mk.ukim.finki.lab2_library_193238.model.exceptions.BookNotFoundException;
import mk.ukim.finki.lab2_library_193238.repository.AuthorRepositoryJPA;
import mk.ukim.finki.lab2_library_193238.repository.BookRepositoryJPA;
import mk.ukim.finki.lab2_library_193238.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepositoryJPA bookRepositoryJPA;
    private final AuthorRepositoryJPA authorRepositoryJPA;

    public BookServiceImpl(BookRepositoryJPA bookRepositoryJPA, AuthorRepositoryJPA authorRepositoryJPA) {
        this.bookRepositoryJPA = bookRepositoryJPA;
        this.authorRepositoryJPA = authorRepositoryJPA;
    }

    @Override
    public List<Book> findAll() {
        return bookRepositoryJPA.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return Optional.of(bookRepositoryJPA.findById(id).orElseThrow(() -> new BookNotFoundException(id)));
    }

    public Optional<Book> saveFromDto(BookDTO bookDTO) {
        Long authorId = bookDTO.getAuthorId();
        Author author = authorRepositoryJPA.findById(authorId).orElseThrow(() -> new AuthorNotFoundException(authorId));
        Book book = new Book(bookDTO.getName(), bookDTO.getCategory(), author, bookDTO.getAvailableCopies());
        return Optional.of(bookRepositoryJPA.save(book));
    }

    @Override
    public Book create(String name, Category category, Long authorId, Integer availableCopies) {
        Author author = authorRepositoryJPA.findById(authorId).orElseThrow(() -> new AuthorNotFoundException(authorId));
        Book book = new Book(name, category, author, availableCopies);
        return bookRepositoryJPA.save(book);
    }

    @Override
    public Optional<Book> editBook(Long id, BookDTO bookDTO) {
        Book book = bookRepositoryJPA.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        Long authorId = bookDTO.getAuthorId();
        Author author = authorRepositoryJPA.findById(authorId).orElseThrow(() -> new AuthorNotFoundException(authorId));
        book.setName(bookDTO.getName());
        book.setCategory(bookDTO.getCategory());
        book.setAuthor(author);
        book.setAvailableCopies(bookDTO.getAvailableCopies());
        return Optional.of(bookRepositoryJPA.save(book));
    }

    @Override
    public Optional<Book> deleteBook(Long id) {
        Book book = bookRepositoryJPA.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        bookRepositoryJPA.delete(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> markAsTaken(Long id) {
        Book book = bookRepositoryJPA.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        book.setAvailableCopies(book.getAvailableCopies()-1);
        return Optional.of(bookRepositoryJPA.save(book));
    }
}
