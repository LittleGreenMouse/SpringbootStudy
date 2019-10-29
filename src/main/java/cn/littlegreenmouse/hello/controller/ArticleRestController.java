package cn.littlegreenmouse.hello.controller;

import cn.littlegreenmouse.hello.model.AjaxResponse;
import cn.littlegreenmouse.hello.model.Article;
import cn.littlegreenmouse.hello.model.Reader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/rest")
public class ArticleRestController {
    // @RequestMapping(value = "/articles", method = POST, produces = "application/json")
    @PostMapping("/articles")
    public AjaxResponse saveArticle(@RequestBody Article article) {
        log.info("Save article: {}", article);
        return AjaxResponse.success(article);
    }

    // @RequestMapping(value = "/articles/{id}", method = DELETE, produces = "application/json")
    @DeleteMapping("/articles/{id}")
    public AjaxResponse deleteArticle(@PathVariable long id) {
        log.info("Delete article: {}", id);
        return AjaxResponse.success(id);
    }

    // @RequestMapping(value = "/articles/{id}", method = PUT, produces = "application/json")
    @PutMapping("/articles/{id}")
    public AjaxResponse updateArticle(@PathVariable long id, @RequestBody Article article) {
        article.setId(id);
        log.info("Update article: {}", article);
        return AjaxResponse.success(article);
    }

    // @RequestMapping(value = "/articles/{id}", method = GET, produces = "application/json")
    @GetMapping("/articles/{id}")
    public AjaxResponse getArticle(@PathVariable long id) {
        ArrayList<Reader> readers = new ArrayList<>();
        readers.add(Reader.builder().name("zh").age(21).build());
        readers.add(Reader.builder().name("whr").age(21).build());
        Article article = Article.builder()
                .id(id)
                .author("LittleMouse")
                .content("Test for restful api")
                .createTime(new Date())
                .title("NB")
                .readers(readers)
                .build();
        return AjaxResponse.success(article);
    }
}
