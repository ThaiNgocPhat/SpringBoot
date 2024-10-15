package ra.exercise.controller.ss2.bt2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ss2/baitap2")
public class ManagerController {

    @RequestMapping
    public String manager() {
        return "ss2/bt2/index";
    }
}
