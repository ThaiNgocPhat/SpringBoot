package ra.exercise.service.ss2.bt1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ra.exercise.entity.ss2.bt1.Employee1;
import ra.exercise.repository.ss2.bt1.Employee1Repository;

import java.util.List;
import java.util.Optional;
@Service
public class Employee1ServiceImpl implements Employee1Service{
    @Autowired
    private Employee1Repository employee1Repository;
    @Override
    public List<Employee1> findAll() {
        return employee1Repository.findAll();
    }

    @Override
    public Optional<Employee1> findById(Integer id) {
        return employee1Repository.findById(id);
    }

    @Override
    public Employee1 save(Employee1 employee) {
        return employee1Repository.save(employee);
    }

    @Override
    public void delete(Integer id) {
        employee1Repository.deleteById(id);
    }

    @Override
    public void update(Employee1 employee) {
        employee1Repository.save(employee);
    }
}
