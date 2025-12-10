package tp.api.library.services;

import org.springframework.stereotype.Service;
import tp.api.library.model.Author;
import tp.api.library.model.Book;
import tp.api.library.model.Category;
import tp.api.library.repository.BookRepository;
import tp.api.library.repository.AuthorRepository;
import tp.api.library.repository.CategoryRepository;

import java.util.List;

@Service
public class BookServices {

    private final BookRepository bookRepo;
    private final AuthorRepository authorRepo;
    private final CategoryRepository categoryRepo;

    public BookServices(BookRepository bookRepo, AuthorRepository authorRepo, CategoryRepository categoryRepo) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
        this.categoryRepo = categoryRepo;
    }

    public List<Book> findAll() {
        return bookRepo.findAll();
    }

    public Book findById(Long id) {
        return bookRepo.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public Book create(Book b, Long authorId, Long categoryId) {
        if (bookRepo.existsByIsbn(b.getIsbn()))
            throw new RuntimeException("ISBN already exists");

        Author a = authorRepo.findById(authorId).orElseThrow(() -> new RuntimeException("Author not found"));
        Category c = categoryRepo.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not found"));

        b.setAuthor(a);
        b.setCategory(c);

        return bookRepo.save(b);
    }

    public Book update(Long id, Book newData, Long authorId, Long categoryId) {
        Book b = findById(id);

        b.setTitle(newData.getTitle());
        b.setIsbn(newData.getIsbn());
        b.setYear(newData.getYear());

        Author a = authorRepo.findById(authorId).orElseThrow(() -> new RuntimeException("Author not found"));
        Category c = categoryRepo.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not found"));

        b.setAuthor(a);
        b.setCategory(c);

        return bookRepo.save(b);
    }

    public void delete(Long id) {
        bookRepo.deleteById(id);
    }
}
