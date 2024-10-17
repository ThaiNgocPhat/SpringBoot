package ra.exercise.service.ss4.bt3.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.exercise.entity.ss4.bt3.Product1;
import ra.exercise.repository.ss4.bt3.Product1Repository;
import ra.exercise.service.ss4.bt3.services.Product1Service;

import java.util.List;
import java.util.Optional;

@Service
public class Product1ServiceImpl implements Product1Service {
    @Autowired
    private Product1Repository product1Repository;
    @Override
    public List<Product1> findAll() {
        return product1Repository.findAll();
    }

    @Override
    public Optional<Product1> findById(Integer id) {
        return product1Repository.findById(id);
    }

    @Override
    public Product1 save(Product1 product1) {
        return product1Repository.save(product1);
    }

    @Override
    public void delete(Integer id) {
        product1Repository.deleteById(id);
    }

    @Override
    public void update(Product1 product1) {
        product1Repository.save(product1);
    }
}
