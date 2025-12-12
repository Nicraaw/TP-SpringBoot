package tp.api.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.api.library.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
