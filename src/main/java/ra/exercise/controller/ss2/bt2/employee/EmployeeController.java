package ra.exercise.controller.ss2.bt2.employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.exercise.entity.ss2.bt2.Department;
import ra.exercise.entity.ss2.bt2.Employee2;
import ra.exercise.service.ss2.bt2.department.DepartmentService;
import ra.exercise.service.ss2.bt2.employee.EmployeeService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/ss2/baitap2/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    // Hiển thị danh sách nhân viên
    @GetMapping
    public String listEmployees(Model model) {
        List<Employee2> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "ss2/bt2/employee/list";
    }

    // Hiển thị form thêm nhân viên
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        Employee2 employee = new Employee2();
        List<Department> departments = departmentService.findAll();
        model.addAttribute("employee", employee);
        model.addAttribute("departments", departments); // Để chọn phòng ban
        return "ss2/bt2/employee/add";
    }

    // Xử lý thêm mới nhân viên
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee2 employee) {
        employeeService.save(employee);
        return "redirect:/ss2/baitap2/employee";
    }

    // Hiển thị form sửa nhân viên
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        Optional<Employee2> employee = employeeService.findById(id);
        if (employee.isPresent()) {
            List<Department> departments = departmentService.findAll();
            model.addAttribute("employee", employee.get());
            model.addAttribute("departments", departments); // Để chọn phòng ban
            return "ss2/bt2/employee/edit";
        }
        return "redirect:/ss2/baitap2/employee"; // Nếu không tìm thấy, quay lại danh sách
    }

    // Xử lý cập nhật thông tin nhân viên
    @PostMapping("/edit")
    public String updateEmployee(@ModelAttribute("employee") Employee2 employee) {
        employeeService.save(employee);
        return "redirect:/ss2/baitap2/employee";
    }

    // Thay đổi trạng thái nhân viên
    @GetMapping("/status/{id}")
    public String changeStatus(@PathVariable("id") Integer id) {
        Optional<Employee2> employee = employeeService.findById(id);
        if (employee.isPresent()) {
            Employee2 emp = employee.get();
            emp.setStatus(!emp.isStatus()); // Thay đổi trạng thái
            employeeService.save(emp);
        }
        return "redirect:/ss2/baitap2/employee"; // Sau khi thay đổi, quay lại danh sách
    }

    // Xóa nhân viên
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeService.delete(id);
        return "redirect:/ss2/baitap2/employee"; // Sau khi xóa, quay lại danh sách
    }
}
