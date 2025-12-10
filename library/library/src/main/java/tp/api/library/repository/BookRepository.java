package tp.api.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.api.library.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    boolean existsByIsbn(String isbn);
}
