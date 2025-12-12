package tp.api.library.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import tp.api.library.model.Book;
import tp.api.library.dto.BookRequestDto;
import tp.api.library.services.BookServices;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookServices service;

    public BookController(BookServices service) {
        this.service = service;
    }

    @PostMapping
    public Book create(@Valid @RequestBody BookRequestDto bookDto) {
        return service.create(bookDto);
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable Long id,
                       @Valid @RequestBody BookRequestDto bookDto) {
        return service.update(id, bookDto);
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable Long id) {
        return this.service.findById(id);
    }

    @GetMapping
    public List<Book> findAll() {
        return this.service.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.service.delete(id);
    }

}