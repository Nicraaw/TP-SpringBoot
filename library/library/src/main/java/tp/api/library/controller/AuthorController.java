package tp.api.library.controller;

import org.springframework.web.bind.annotation.*;
import tp.api.library.model.Author;
import tp.api.library.services.AuthorService;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService service;

    public AuthorController(AuthorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Author> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Author one(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Author create(@RequestBody Author a) {
        return service.create(a);
    }

    @PutMapping("/{id}")
    public Author update(@PathVariable Long id, @RequestBody Author a) {
        return service.update(id, a);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
