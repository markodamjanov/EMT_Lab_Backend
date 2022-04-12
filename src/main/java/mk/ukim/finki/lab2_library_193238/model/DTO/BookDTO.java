package mk.ukim.finki.lab2_library_193238.model.DTO;

import lombok.Data;
import mk.ukim.finki.lab2_library_193238.model.enumerations.Category;

@Data
public class BookDTO {

    private String name;

    private Category category;

    private Long authorId;

    private Integer availableCopies;

    public BookDTO() {
    }

    public BookDTO(String name, Category category, Long authorId, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.authorId = authorId;
        this.availableCopies = availableCopies;
    }
}
