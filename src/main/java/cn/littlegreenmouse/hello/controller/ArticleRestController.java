package cn.littlegreenmouse.hello.controller;

import cn.littlegreenmouse.hello.model.AjaxResponse;
import cn.littlegreenmouse.hello.model.Article;
import cn.littlegreenmouse.hello.model.Reader;
import cn.littlegreenmouse.hello.service.ArticleRestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/rest")
public class ArticleRestController {
    @Resource(name = "articleRestServiceJDBCImpl")
    ArticleRestService articleRestService;

    // @RequestMapping(value = "/articles", method = POST, produces = "application/json")
    @PostMapping("/articles")
    public AjaxResponse saveArticle(@RequestBody Article article) {
        articleRestService.saveArticle(article);
        return AjaxResponse.success(article);
    }

    // @RequestMapping(value = "/articles/{id}", method = DELETE, produces = "application/json")
    @DeleteMapping("/articles/{id}")
    public AjaxResponse deleteArticle(@PathVariable long id) {
        articleRestService.deleteArticle(id);
        return AjaxResponse.success(id);
    }

    // @RequestMapping(value = "/articles/{id}", method = PUT, produces = "application/json")
    @PutMapping("/articles/{id}")
    public AjaxResponse updateArticle(@PathVariable long id, @RequestBody Article article) {
        article.setId(id);
        articleRestService.updateArticle(article);
        return AjaxResponse.success(article);
    }

    // @RequestMapping(value = "/articles/{id}", method = GET, produces = "application/json")
    @GetMapping("/articles/{id}")
    public AjaxResponse getArticle(@PathVariable long id) {
        return AjaxResponse.success(articleRestService.getArticle(id));
    }

    @GetMapping("/articles")
    public AjaxResponse getAllArticle() {
        return AjaxResponse.success(articleRestService.getAll());
    }
}
