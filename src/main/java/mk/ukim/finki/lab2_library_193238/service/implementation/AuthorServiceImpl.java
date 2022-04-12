package mk.ukim.finki.lab2_library_193238.service.implementation;

import mk.ukim.finki.lab2_library_193238.model.Author;
import mk.ukim.finki.lab2_library_193238.model.exceptions.AuthorNotFoundException;
import mk.ukim.finki.lab2_library_193238.repository.AuthorRepositoryJPA;
import mk.ukim.finki.lab2_library_193238.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepositoryJPA authorRepositoryJPA;

    public AuthorServiceImpl(AuthorRepositoryJPA authorRepositoryJPA) {
        this.authorRepositoryJPA = authorRepositoryJPA;
    }

    @Override
    public List<Author> findAll() {
        return authorRepositoryJPA.findAll();
    }

    @Override
    public Author findById(Long id) {
        return authorRepositoryJPA.findById(id).orElseThrow(() -> new AuthorNotFoundException(id));
    }

    @Override
    public Author create(Author author) {
        return authorRepositoryJPA.save(author);
    }
}
