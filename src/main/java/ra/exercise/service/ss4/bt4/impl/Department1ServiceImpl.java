package ra.exercise.service.ss4.bt4.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.exercise.entity.ss4.bt4.Department1;
import ra.exercise.repository.ss4.bt4.Department1Repository;
import ra.exercise.service.ss4.bt4.services.Department1Service;

import java.util.List;
import java.util.Optional;
@Service
public class Department1ServiceImpl implements Department1Service {
    @Autowired
    private Department1Repository department1Repository;
    @Override
    public List<Department1> findAll() {
        return department1Repository.findAll();
    }

    @Override
    public Optional<Department1> findById(Integer id) {
        return department1Repository.findById(id);
    }

    @Override
    public Department1 save(Department1 department1) {
        return department1Repository.save(department1);
    }

    @Override
    public void delete(Integer id) {
        department1Repository.deleteById(id);
    }

    @Override
    public void update(Department1 department1) {
        department1Repository.save(department1);
    }
}
