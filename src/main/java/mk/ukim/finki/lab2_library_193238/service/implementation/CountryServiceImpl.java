package mk.ukim.finki.lab2_library_193238.service.implementation;

import mk.ukim.finki.lab2_library_193238.model.Country;
import mk.ukim.finki.lab2_library_193238.model.exceptions.CountryNotFoundException;
import mk.ukim.finki.lab2_library_193238.repository.CountryRepositoryJPA;
import mk.ukim.finki.lab2_library_193238.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepositoryJPA countryRepositoryJPA;

    public CountryServiceImpl(CountryRepositoryJPA countryRepositoryJPA) {
        this.countryRepositoryJPA = countryRepositoryJPA;
    }

    @Override
    public List<Country> findAll() {
        return countryRepositoryJPA.findAll();
    }

    @Override
    public Country findById(Long id) {
        return countryRepositoryJPA.findById(id).orElseThrow(() -> new CountryNotFoundException(id));
    }

    @Override
    public Country create(Country country) {
        return countryRepositoryJPA.save(country);
    }
}
