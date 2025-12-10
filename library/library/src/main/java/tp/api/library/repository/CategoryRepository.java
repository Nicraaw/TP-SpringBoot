package tp.api.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.api.library.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
