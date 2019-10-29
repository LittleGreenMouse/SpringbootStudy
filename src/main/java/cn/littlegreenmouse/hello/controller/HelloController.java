package cn.littlegreenmouse.hello.controller;

import cn.littlegreenmouse.hello.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public Article index(String name) {
        // Article article = new Article(1,name);

        Article article = Article.builder().id(1).author(name).build();

        log.info("test: " + article);

        return article;
    }
}
