package ra.exercise.repository.ss2.bt2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.exercise.entity.ss2.bt2.Department;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
