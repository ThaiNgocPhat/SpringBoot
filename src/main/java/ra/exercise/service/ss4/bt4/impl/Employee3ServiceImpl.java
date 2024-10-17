package ra.exercise.service.ss4.bt4.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.exercise.entity.ss4.bt4.Employee3;
import ra.exercise.repository.ss4.bt4.Employee3Repository;
import ra.exercise.service.ss4.bt4.services.Employee3Service;

import java.util.List;
import java.util.Optional;
@Service
public class Employee3ServiceImpl implements Employee3Service {
    @Autowired
    private Employee3Repository employee3Repository;
    @Override
    public List<Employee3> findAll() {
        return employee3Repository.findAll();
    }

    @Override
    public Optional<Employee3> findById(Integer id) {
        return employee3Repository.findById(id);
    }

    @Override
    public Employee3 save(Employee3 employee3) {
        return employee3Repository.save(employee3);
    }

    @Override
    public void delete(Integer id) {
        employee3Repository.deleteById(id);
    }

    @Override
    public void update(Employee3 employee3) {
        employee3Repository.save(employee3);
    }
}
