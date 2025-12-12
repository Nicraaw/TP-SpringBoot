package tp.api.library.dto;

import jakarta.validation.constraints.*;
import tp.api.library.model.Category;

public class BookRequestDto {

    @NotBlank(message = "Le titre est obligatoire.")
    @Size(max = 255, message = "Le titre ne doit pas dépasser 255 caractères.")
    private String title;

    @Pattern(regexp = "^(ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$",
            message = "Le format ISBN est incorrect.")
    @NotBlank(message = "L'ISBN est obligatoire.")
    private String isbn;

    @NotNull(message = "L'année est obligatoire.")
    @Min(value = 1450, message = "L'année de publication ne peut être antérieure à 1450.")
    @Max(value = 2025, message = "L'année de publication ne peut être dans le futur.")
    private Integer year;

    @NotNull(message = "La catégorie est obligatoire.")
    private Category category;

    @NotNull(message = "L'ID de l'auteur est obligatoire.")
    private Long authorId;

    // --- Getters et Setters ---

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }

    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getAuthorId() {
        return authorId;
    }
    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}