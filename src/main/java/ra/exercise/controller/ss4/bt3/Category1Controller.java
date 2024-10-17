package ra.exercise.controller.ss4.bt3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.exercise.entity.ss4.bt3.Category1;
import ra.exercise.service.ss4.bt3.services.Category1Service;

import java.util.List;

@RestController
@RequestMapping("/category1")
public class Category1Controller {
    @Autowired
    private Category1Service category1Service;

    @GetMapping
    public ResponseEntity<List<Category1>> findAll(){
        List<Category1> category1s = category1Service.findAll();
        return ResponseEntity.ok(category1s);
    }

    @PostMapping
    public ResponseEntity<Category1> addCategory1(@RequestBody Category1 category1){
        Category1 newCategory1 = category1Service.save(category1);
        return ResponseEntity.ok(newCategory1);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category1> updateCategory1(@PathVariable Integer id, @RequestBody Category1 category1){
        category1.setCategoryId(id);
        Category1 updatedCategory1 = category1Service.save(category1);
        return ResponseEntity.ok(updatedCategory1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory1(@PathVariable Integer id){
        category1Service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category1> findByIdCategory1(@PathVariable Integer id){
        return category1Service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
