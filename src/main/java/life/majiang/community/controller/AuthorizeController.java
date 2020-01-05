package life.majiang.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description
 * @auther 1
 * @create 2020-01-05 22:03
 */
@Controller
public class AuthorizeController {
    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code, @RequestParam(name = "state") String state) {
        return "index";
    }
}
