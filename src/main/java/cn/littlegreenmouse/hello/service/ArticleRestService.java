package cn.littlegreenmouse.hello.service;

import cn.littlegreenmouse.hello.model.ArticleVO;

import java.util.List;

public interface ArticleRestService {

    ArticleVO saveArticle(ArticleVO article);

    void deleteArticle(long id);

    void updateArticle(ArticleVO article);

    ArticleVO getArticle(long id);

    List<ArticleVO> getAll();
}
