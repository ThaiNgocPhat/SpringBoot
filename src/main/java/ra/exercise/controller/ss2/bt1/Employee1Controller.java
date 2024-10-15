package ra.exercise.controller.ss2.bt1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.exercise.entity.ss2.bt1.Employee1;
import ra.exercise.service.ss2.bt1.Employee1Service;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/ss2/baitap1")
public class Employee1Controller {
    @Autowired
    private Employee1Service employee1Service;
    @GetMapping
    public String listEmployees(Model model) {
        List<Employee1> employees = employee1Service.findAll();
        model.addAttribute("employees", employees);
        return "ss2/bt1/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new Employee1());
        return "ss2/bt1/add";
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute Employee1 employee) {
        employee1Service.save(employee);
        return "redirect:/ss2/baitap1";
    }

    @GetMapping("/edit/{employeeId}")
    public String showEditForm(@PathVariable Integer employeeId, Model model) {
        Optional<Employee1> optionalEmployee = employee1Service.findById(employeeId);

        if (optionalEmployee.isPresent()) {
            model.addAttribute("employee", optionalEmployee.get());
        } else {
            return "redirect:/ss2/baitap1"; // chuyển hướng về danh sách nhân viên
        }

        return "ss2/bt1/edit";
    }

    @PostMapping("/edit")
    public String editEmployee(@ModelAttribute Employee1 employee) {
        employee1Service.update(employee);
        return "redirect:/ss2/baitap1"; // chuyển hướng về danh sách nhân viên
    }


    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Integer id) {
        employee1Service.delete(id);
        return "redirect:/ss2/baitap1"; // Chuyển hướng về danh sách nhân viên
    }
}
