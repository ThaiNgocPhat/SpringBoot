package ra.exercise.controller.ss2.bt4.projects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.exercise.entity.ss2.bt4.Customers;
import ra.exercise.entity.ss2.bt4.Projects;
import ra.exercise.service.ss2.bt4.customers.CustomersService;
import ra.exercise.service.ss2.bt4.projects.ProjectsService;

import java.util.List;

@Controller
@RequestMapping("/ss2/baitap4/projects")
public class ProjectsController {
    @Autowired
    private ProjectsService projectsService;

    @Autowired
    private CustomersService customersService;

    @GetMapping
    public String projects(Model model) {
        List<Projects> projects = projectsService.findAll();
        model.addAttribute("projects", projects);
        return "/ss2/bt4/projects/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        List<Customers> customers = customersService.findAll();
        model.addAttribute("customers", customers);
        model.addAttribute("project", new Projects());
        return "/ss2/bt4/projects/add";
    }

    @PostMapping("/add")
    public String addProject(@ModelAttribute Projects project) {
        projectsService.save(project);
        return "redirect:/ss2/baitap4/projects";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        model.addAttribute("project", projectsService.findById(id));
        return "/ss2/bt4/projects/edit";
    }

    @PostMapping("/edit/{id}")
    public String editProject(@PathVariable Integer id, @ModelAttribute Projects project) {
        project.setProjectId(id);
        projectsService.save(project);
        return "redirect:/ss2/baitap4/projects";
    }

    @GetMapping("/delete/{id}")
    public String deleteProject(@PathVariable Integer id) {
        projectsService.delete(id);
        return "redirect:/ss2/baitap4/projects";
    }
}

