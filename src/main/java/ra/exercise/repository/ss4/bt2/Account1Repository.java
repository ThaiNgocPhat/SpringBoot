package ra.exercise.repository.ss4.bt2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.exercise.entity.ss4.bt2.Account1;

@Repository
public interface Account1Repository extends JpaRepository<Account1, Integer> {
}
