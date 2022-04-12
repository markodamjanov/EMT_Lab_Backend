package mk.ukim.finki.lab2_library_193238.repository;

import mk.ukim.finki.lab2_library_193238.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepositoryJPA extends JpaRepository<Author, Long> {
}
