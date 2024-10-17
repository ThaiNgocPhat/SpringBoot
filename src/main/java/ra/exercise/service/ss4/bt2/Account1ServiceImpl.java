package ra.exercise.service.ss4.bt2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ra.exercise.entity.ss4.bt2.Account1;
import ra.exercise.repository.ss4.bt2.Account1Repository;

import java.util.List;
import java.util.Optional;

@Service
public class Account1ServiceImpl implements Account1Service{
    @Autowired
    private Account1Repository account1Repository;
    @Override
    public List<Account1> findAll() {
        return account1Repository.findAll();
    }

    @Override
    public Optional<Account1> findById(Integer id) {
        return account1Repository.findById(id);
    }

    @Override
    public Account1 save(Account1 account) {
        return account1Repository.save(account);
    }

    @Override
    public void delete(Integer id) {
        account1Repository.deleteById(id);
    }

    @Override
    public void update(Account1 account){
        account1Repository.save(account);
    }

    @Override
    public Page<Account1> getAllAccounts(int page, int size) {
        return account1Repository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Account1 changeAccountStatus(int id, boolean status) {
        Account1 account = account1Repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Account not found"));
        account.setStatus(status);
        return account1Repository.save(account);
    }
}
