package life.majiang.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description
 * @auther 1
 * @create 2020-01-04 17:34
 */
@Controller
public class HelloController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
