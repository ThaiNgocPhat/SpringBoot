package ra.exercise.repository.ss1.bt3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.exercise.entity.ss1.bt3.Account;
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
}
