package cn.littlegreenmouse.hello.controller;

import cn.littlegreenmouse.hello.model.AjaxResponse;
import cn.littlegreenmouse.hello.model.ArticleVO;
import cn.littlegreenmouse.hello.service.ArticleRestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/rest")
public class ArticleRestController {
    @Resource(name = "articleRestJPAServiceImpl")
    ArticleRestService articleRestService;

    @PostMapping("/articles")
    public AjaxResponse saveArticle(@RequestBody ArticleVO articleVO) {
        articleRestService.saveArticle(articleVO);
        return AjaxResponse.success(articleVO);
    }

    @DeleteMapping("/articles/{id}")
    public AjaxResponse deleteArticle(@PathVariable long id) {
        articleRestService.deleteArticle(id);
        return AjaxResponse.success(id);
    }

    @PutMapping("/articles/{id}")
    public AjaxResponse updateArticle(@PathVariable long id, @RequestBody ArticleVO articleVO) {
        articleVO.setId(id);
        articleRestService.updateArticle(articleVO);
        return AjaxResponse.success(articleVO);
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
