package mk.ukim.finki.lab2_library_193238.service;

import mk.ukim.finki.lab2_library_193238.model.Country;

import java.util.List;

public interface CountryService {
    List<Country> findAll();

    Country findById(Long id);

    Country create(Country country);
}
