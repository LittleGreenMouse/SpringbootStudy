package cn.littlegreenmouse.hello.controller;

import cn.littlegreenmouse.hello.model.AjaxResponse;
import cn.littlegreenmouse.hello.model.ArticleVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import cn.littlegreenmouse.hello.service.ArticleRestService;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/rest")
public class ArticleRestController {

    @Resource(name = "articleMybatisRestServiceImpl")
    ArticleRestService articleRestService;

    @PostMapping("/articles")
    public AjaxResponse saveArticle(@RequestBody ArticleVO article) {
        articleRestService.saveArticle(article);
        return AjaxResponse.success(article);
    }

    @DeleteMapping("/articles/{id}")
    public AjaxResponse deleteArticle(@PathVariable long id) {
        articleRestService.deleteArticle(id);
        return AjaxResponse.success(id);
    }

    @PutMapping("/articles/{id}")
    public AjaxResponse updateArticle(@PathVariable long id, @RequestBody ArticleVO article) {
        article.setId(id);
        articleRestService.updateArticle(article);
        return AjaxResponse.success(article);
    }

    @GetMapping("/articles/{id}")
    public AjaxResponse getArticle(@PathVariable long id) {
        return AjaxResponse.success(articleRestService.getArticle(id));
    }

    @GetMapping("/articles")
    public AjaxResponse getAll() {
        return AjaxResponse.success(articleRestService.getAll());
    }
}
