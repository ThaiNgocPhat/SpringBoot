package ra.exercise.controller.ss4.bt4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.exercise.entity.ss4.bt4.Department1;
import ra.exercise.entity.ss4.bt4.Employee3;
import ra.exercise.service.ss4.bt4.services.Department1Service;
import ra.exercise.service.ss4.bt4.services.Employee3Service;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/department1")
public class Department1Controller {
    @Autowired
    private Department1Service department1Service;

    @Autowired
    private Employee3Service employee3Service;

    @GetMapping
    public ResponseEntity<List<Department1>> findAll(){
        List<Department1> department1s = department1Service.findAll();
        return ResponseEntity.ok(department1s);
    }

    @PostMapping
    public ResponseEntity<Department1> addDepartment(@RequestBody Department1 department1){
        Department1 addDepartment = department1Service.save(department1);
        return ResponseEntity.ok(addDepartment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department1> updateDepartment(@PathVariable Integer id, @RequestBody Department1 department1){
        department1.setDepartmentId(id);
        Department1 updateDepartment = department1Service.save(department1);
        return ResponseEntity.ok(updateDepartment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Integer id){
        department1Service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department1> findDepartmentById(@PathVariable Integer id){
        return department1Service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/departments/{id}/status")
    public ResponseEntity<Department1> changeDepartmentStatus(@PathVariable int id, @RequestParam boolean status) {
        Optional<Department1> department = department1Service.findById(id);
        if (department.isPresent()) {
            Department1 existingDepartment = department.get();
            existingDepartment.setStatus(status);
            Department1 updatedDepartment = department1Service.save(existingDepartment);
            return ResponseEntity.ok(updatedDepartment);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/employees/add")
    public ResponseEntity<Employee3> addEmployeeToDepartment(@RequestBody Employee3 employee, @RequestParam int departmentId) {
        Optional<Department1> department = department1Service.findById(departmentId);
        if (department.isPresent()) {
            employee.setDepartment(department.get());
            Employee3 newEmployee = employee3Service.save(employee);
            return ResponseEntity.status(HttpStatus.CREATED).body(newEmployee);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/employees/{id}/remove-from-department")
    public ResponseEntity<Employee3> removeEmployeeFromDepartment(@PathVariable int id) {
        Optional<Employee3> employee = employee3Service.findById(id);
        if (employee.isPresent()) {
            Employee3 existingEmployee = employee.get();
            existingEmployee.setDepartment(null); // Xóa liên kết phòng ban
            Employee3 updatedEmployee = employee3Service.save(existingEmployee);
            return ResponseEntity.ok(updatedEmployee);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
