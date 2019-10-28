package cn.littlegreenmouse.hello.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String index(String name) {
        return "Welcome here, " + name + "!";
    }
}
