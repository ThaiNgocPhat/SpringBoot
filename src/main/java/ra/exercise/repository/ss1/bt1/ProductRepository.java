package ra.exercise.repository.ss1.bt1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.exercise.entity.ss1.bt1.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
