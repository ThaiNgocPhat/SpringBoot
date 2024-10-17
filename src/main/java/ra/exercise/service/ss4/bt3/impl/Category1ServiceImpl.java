package ra.exercise.service.ss4.bt3.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.exercise.entity.ss4.bt3.Category1;
import ra.exercise.repository.ss4.bt3.Category1Repository;
import ra.exercise.service.ss4.bt3.services.Category1Service;

import java.util.List;
import java.util.Optional;

@Service
public class Category1ServiceImpl implements Category1Service {
    @Autowired
    private Category1Repository category1Repository;
    @Override
    public List<Category1> findAll() {
        return category1Repository.findAll();
    }

    @Override
    public Optional<Category1> findById(Integer id) {
        return category1Repository.findById(id);
    }

    @Override
    public Category1 save(Category1 category1) {
        return category1Repository.save(category1);
    }

    @Override
    public void delete(Integer id) {
        category1Repository.deleteById(id);
    }

    @Override
    public void update(Category1 category1) {
        category1Repository.save(category1);
    }
}
