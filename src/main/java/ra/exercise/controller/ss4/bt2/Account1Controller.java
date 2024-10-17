package ra.exercise.controller.ss4.bt2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.exercise.entity.ss1.bt3.Account;
import ra.exercise.entity.ss4.bt2.Account1;
import ra.exercise.service.ss4.bt2.Account1Service;

import java.util.List;

@RestController
@RequestMapping("/account1")
public class Account1Controller {
    @Autowired
    private Account1Service account1Service;

    @GetMapping
    public ResponseEntity<List<Account1>> findAll(){
        List<Account1> getAll = account1Service.findAll();
        return ResponseEntity.ok(getAll);
    }

    @PostMapping
    public ResponseEntity<Account1> addAccount(@RequestBody Account1 account){
        Account1 newAccount = account1Service.save(account);
        return ResponseEntity.ok(newAccount);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account1> updateAccount(@PathVariable Integer id, @RequestBody Account1 account){
        account.setAccountId(id);
        Account1 updatedAccount = account1Service.save(account);
        return ResponseEntity.ok(updatedAccount);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Account1> deleteAccount(@PathVariable Integer id){
        account1Service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account1> findById(@PathVariable Integer id){
        Account1 account = account1Service.findById(id).orElseThrow(() -> new IllegalArgumentException("Account not found"));
        return ResponseEntity.ok(account);
    }
}
