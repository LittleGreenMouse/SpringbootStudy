package cn.littlegreenmouse.hello.controller;

import cn.littlegreenmouse.hello.customlistener.MyEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/listener")
public class ListenerController {
    @Resource
    ApplicationContext applicationContext;

    @GetMapping("/")
    public String index() {

        log.info("发布事件");
        applicationContext.publishEvent(new MyEvent("测试事件."));

        return "ok";
    }
}
