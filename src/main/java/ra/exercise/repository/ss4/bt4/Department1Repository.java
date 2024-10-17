package ra.exercise.repository.ss4.bt4;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.exercise.entity.ss4.bt4.Department1;

@Repository
public interface Department1Repository extends JpaRepository<Department1, Integer> {
}
