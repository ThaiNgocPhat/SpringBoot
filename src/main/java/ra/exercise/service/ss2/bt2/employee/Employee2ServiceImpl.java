package ra.exercise.service.ss2.bt2.employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.exercise.entity.ss2.bt2.Employee2;
import ra.exercise.repository.ss2.bt2.Employee2Repository;

import java.util.List;
import java.util.Optional;

@Service
public class Employee2ServiceImpl implements EmployeeService{
    @Autowired
    private Employee2Repository employeeRepository;
    @Override
    public List<Employee2> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee2> findById(Integer id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee2 save(Employee2 employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void update(Employee2 employee) {
        employeeRepository.save(employee);
    }
}
