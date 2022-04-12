package mk.ukim.finki.lab2_library_193238.web.RestControllers;
import mk.ukim.finki.lab2_library_193238.model.Book;
import mk.ukim.finki.lab2_library_193238.model.DTO.BookDTO;
import mk.ukim.finki.lab2_library_193238.model.enumerations.Category;
import mk.ukim.finki.lab2_library_193238.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api")
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping({"/","/books"})
    public List<Book> getBooksPage() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        return bookService.findById(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/addBook")
    public ResponseEntity<Book> createBook(@RequestBody BookDTO bookDTO) {
        return bookService.saveFromDto(bookDTO)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/editBook/{id}")
    public ResponseEntity<Book> editBook(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        return bookService.editBook(id, bookDTO)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Long id) {
        return bookService.deleteBook(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/mark/{id}")
    public ResponseEntity<Book> markAsTaken(@PathVariable Long id) {
        return bookService.markAsTaken(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("/categories")
    public List<Category> findAllCategories() {
        List<Category> categories = Arrays.asList(Category.values());
        return categories;
    }
}
