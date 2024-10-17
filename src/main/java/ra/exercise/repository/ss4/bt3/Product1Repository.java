package ra.exercise.repository.ss4.bt3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.exercise.entity.ss4.bt3.Product1;
@Repository
public interface Product1Repository extends JpaRepository<Product1, Integer> {
}
