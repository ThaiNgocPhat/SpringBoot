package ra.exercise.repository.ss2.bt1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.exercise.entity.ss2.bt1.Employee1;

@Repository
public interface Employee1Repository extends JpaRepository<Employee1, Integer> {
}
