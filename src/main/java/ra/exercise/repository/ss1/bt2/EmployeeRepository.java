package ra.exercise.repository.ss1.bt2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.exercise.entity.ss1.bt2.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //tìm kiếm theo tên hoặc phòng ban
    List<Employee> findByFullNameContainingOrDepartmentNameContaining(String fullName, String departmentName);
}
