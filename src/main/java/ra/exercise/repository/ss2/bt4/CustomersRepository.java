package ra.exercise.repository.ss2.bt4;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.exercise.entity.ss2.bt4.Customers;
@Repository
public interface CustomersRepository extends JpaRepository<Customers, Integer> {
}
