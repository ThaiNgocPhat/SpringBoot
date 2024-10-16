package ra.exercise.repository.ss3;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.exercise.entity.ss3.Book;
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Page<Book> findByNameContainingOrCategoryNameContaining(String name, String categoryName, Pageable pageable);
}
