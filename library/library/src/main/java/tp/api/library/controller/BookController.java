package tp.api.library.controller;

import org.springframework.web.bind.annotation.*;
import tp.api.library.model.Book;
import tp.api.library.services.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
    public List<Book> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Book one(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Book create(@RequestBody Book b,
                       @RequestParam Long authorId,
                       @RequestParam Long categoryId) {

        return service.create(b, authorId, categoryId);
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable Long id,
                       @RequestBody Book b,
                       @RequestParam Long authorId,
                       @RequestParam Long categoryId) {

        return service.update(id, b, authorId, categoryId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
