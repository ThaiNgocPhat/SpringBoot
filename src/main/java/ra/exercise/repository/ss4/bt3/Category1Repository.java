package ra.exercise.repository.ss4.bt3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.exercise.entity.ss4.bt3.Category1;
@Repository
public interface Category1Repository extends JpaRepository<Category1, Integer> {
}
