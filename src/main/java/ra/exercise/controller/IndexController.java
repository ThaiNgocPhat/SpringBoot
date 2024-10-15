package ra.exercise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class IndexController {

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("ss1")
    public String ss1() {
        return "ss1/index";
    }

    @GetMapping("ss2")
    public String ss2() {
        return "ss2/index";
    }

    @GetMapping("ss3")
    public String ss3() {
        return "ss3/index";
    }

    @GetMapping("ss4")
    public String ss4() {
        return "ss4/index";
    }

    @GetMapping("ss5")
    public String ss5() {
        return "ss5/index";
    }

    @GetMapping("ss6")
    public String ss6() {
        return "ss6/index";
    }
}
