package ra.exercise.controller.ss2.bt4.customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.exercise.entity.ss2.bt4.Customers;
import ra.exercise.service.ss2.bt4.customers.CustomersService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/ss2/baitap4/customers")
public class CustomersController {
    @Autowired
    private CustomersService customersService;

    @GetMapping
    public String customers(Model model){
        List<Customers> customers = customersService.findAll();
        model.addAttribute("customers", customers);
        return "/ss2/bt4/customers/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("customer", new Customers());
        return "/ss2/bt4/customers/add";
    }

    @PostMapping("/add")
    public String addCustomer(@ModelAttribute Customers customer) {
        customersService.save(customer);
        return "redirect:/ss2/baitap4/customers";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Optional<Customers> optionalCustomer = customersService.findById(id);
        if (optionalCustomer.isPresent()) {
            model.addAttribute("customer", optionalCustomer.get());
            return "/ss2/bt4/customers/edit"; // Đường dẫn đến tệp HTML
        } else {
            // Xử lý khi không tìm thấy khách hàng
            return "redirect:/ss2/baitap4/customers"; // Chuyển hướng về danh sách khách hàng
        }
    }


    @PostMapping("/edit/{id}")
    public String editCustomer(@PathVariable Integer id, @ModelAttribute Customers customer) {
        customer.setCustomerId(id);
        customersService.save(customer);
        return "redirect:/ss2/baitap4/customers";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Integer id) {
        customersService.delete(id);
        return "redirect:/ss2/baitap4/customers";
    }
}
