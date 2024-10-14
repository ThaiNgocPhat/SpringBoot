package ra.exercise.service.ss1.bt2;

import ra.exercise.entity.ss1.bt2.Employee;
import ra.exercise.service.IGeneric;

import java.util.List;

public interface EmployeeService extends IGeneric<Employee, Integer> {
    //tìm kiếm theo tên hoặc phòng ban
    List<Employee> findByFullNameContainingOrDepartmentNameContaining(String fullName, String departmentName);
}
