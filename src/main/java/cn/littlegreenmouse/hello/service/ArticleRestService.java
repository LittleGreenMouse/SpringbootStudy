package cn.littlegreenmouse.hello.service;

import cn.littlegreenmouse.hello.model.ArticleVO;

import java.util.List;

public interface ArticleRestService {
    public ArticleVO saveArticle(ArticleVO articleVO);

    public void deleteArticle(long id);

    public void updateArticle(ArticleVO articleVO);

    public ArticleVO getArticle(long id);

    public List<ArticleVO> getAll();
}
