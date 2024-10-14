package ra.exercise.service.ss1.bt2.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.exercise.entity.ss1.bt2.Employee;
import ra.exercise.repository.ss1.bt2.EmployeeRepository;
import ra.exercise.service.ss1.bt2.EmployeeService;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void update(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findByFullNameContainingOrDepartmentNameContaining(String fullName, String departmentName) {
        return employeeRepository.findByFullNameContainingOrDepartmentNameContaining(fullName, departmentName);
    }
}
