package mk.ukim.finki.lab2_library_193238.model.exceptions;

public class CountryNotFoundException extends RuntimeException {
    public CountryNotFoundException(Long id) {
        super(String.format("Country with id: %d was not found!", id));
    }
}
