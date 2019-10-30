package cn.littlegreenmouse.hello.service;

import cn.littlegreenmouse.hello.model.Article;

import java.util.List;

public interface ArticleRestService {

    public Article saveArticle(Article article);

    public void deleteArticle(long id);

    public Article updateArticle(Article article);

    public Article getArticle(long id);

    public List<Article> getAll();

}
