package ra.exercise.controller.ss4.bt3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.exercise.entity.ss4.bt3.Product1;
import ra.exercise.service.ss4.bt3.services.Product1Service;

import java.util.List;

@RestController
@RequestMapping("/product1")
public class Product1Controller {
    @Autowired
    private Product1Service product1Service;

    @GetMapping
    public ResponseEntity<List<Product1>> findAll(){
        List<Product1> product1s = product1Service.findAll();
        return ResponseEntity.ok(product1s);
    }

    @PostMapping
    public ResponseEntity<Product1> addProduct1(@RequestBody Product1 product1){
        Product1 newProduct1 = product1Service.save(product1);
        return ResponseEntity.ok(newProduct1);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product1> updateProduct1(@PathVariable Integer id, @RequestBody Product1 product1){
        product1.setProductId(id);
        Product1 updatedProduct1 = product1Service.save(product1);
        return ResponseEntity.ok(updatedProduct1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct1(@PathVariable Integer id){
        product1Service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product1> findById(@PathVariable Integer id){
        Product1 product1 = product1Service.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found"));
        return ResponseEntity.ok(product1);
    }
}
