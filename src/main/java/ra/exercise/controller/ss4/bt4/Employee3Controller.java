package ra.exercise.controller.ss4.bt4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.exercise.entity.ss4.bt4.Employee3;
import ra.exercise.service.ss4.bt4.services.Employee3Service;

import java.util.List;

@RestController
@RequestMapping("/employee3")
public class Employee3Controller {
    @Autowired
    private Employee3Service employee3Service;
    @GetMapping
    public ResponseEntity<List<Employee3>> findAll(){
        List<Employee3> employees = employee3Service.findAll();
        return ResponseEntity.ok(employees);
    }

    @PostMapping
    public ResponseEntity<Employee3> addEmployee(@RequestBody Employee3 employee3){
        Employee3 addEmployee = employee3Service.save(employee3);
        return ResponseEntity.ok(addEmployee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee3> updateEmployee(@PathVariable Integer id, @RequestBody Employee3 employee3){
        employee3.setEmployeeId(id);
        Employee3 updateEmployee = employee3Service.save(employee3);
        return ResponseEntity.ok(updateEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer id){
        employee3Service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee3> findEmployeeById(@PathVariable Integer id){
        return employee3Service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
