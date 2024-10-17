package ra.exercise.service.ss4.bt2;
import org.springframework.data.domain.Page;
import ra.exercise.entity.ss4.bt2.Account1;
import ra.exercise.service.IGeneric;

public interface Account1Service extends IGeneric<Account1, Integer> {
    Page<Account1> getAllAccounts(int page, int size);
    Account1 changeAccountStatus(int id, boolean status);
}
