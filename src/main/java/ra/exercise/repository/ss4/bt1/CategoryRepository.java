package ra.exercise.repository.ss4.bt1;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.exercise.entity.ss4.bt1.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
