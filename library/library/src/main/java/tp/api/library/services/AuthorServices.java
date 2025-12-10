package tp.api.library.services;

import org.springframework.stereotype.Service;
import tp.api.library.model.Author;
import tp.api.library.repository.AuthorRepository;

import java.util.List;

@Service
public class AuthorServices {

    private final AuthorRepository repo;

    public AuthorServices(AuthorRepository repo) {
        this.repo = repo;
    }

    public List<Author> findAll() {
        return repo.findAll();
    }

    public Author findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }

    public Author create(Author a) {
        return repo.save(a);
    }

    public Author update(Long id, Author newData) {
        Author a = findById(id);
        a.setFirstName(newData.getFirstName());
        a.setLastName(newData.getLastName());
        a.setBirthYear(newData.getBirthYear());
        return repo.save(a);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
