package ra.exercise.controller.ss2.bt4;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ss2/baitap4")
public class CustomerProjectController {
    @RequestMapping
    public String customerProject() {
        return "ss2/bt4/index";
    }
}
