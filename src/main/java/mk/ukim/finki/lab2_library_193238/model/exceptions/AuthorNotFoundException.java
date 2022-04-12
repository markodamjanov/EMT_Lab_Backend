package mk.ukim.finki.lab2_library_193238.model.exceptions;

public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(Long id) {
        super(String.format("Author with id: %d was not found!", id));
    }
}
