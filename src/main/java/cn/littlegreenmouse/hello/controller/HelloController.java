package cn.littlegreenmouse.hello.controller;

import cn.littlegreenmouse.hello.model.ArticleVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public ArticleVO index(String name) {
        // Article article = new Article(1,name);

        ArticleVO article = ArticleVO.builder().id(1).author(name).build();

        log.info("test: " + article);

        return article;
    }
}
