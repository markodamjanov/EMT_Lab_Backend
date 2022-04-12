package mk.ukim.finki.lab2_library_193238.repository;

import mk.ukim.finki.lab2_library_193238.model.Country;
import mk.ukim.finki.lab2_library_193238.model.enumerations.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepositoryJPA extends JpaRepository<Country, Long> {
}
