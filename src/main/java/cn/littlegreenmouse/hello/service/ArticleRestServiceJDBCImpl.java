package cn.littlegreenmouse.hello.service;


import cn.littlegreenmouse.hello.dao.ArticleJDBCDAO;
import cn.littlegreenmouse.hello.model.Article;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticleRestServiceJDBCImpl implements ArticleRestService {
    @Resource
    private ArticleJDBCDAO articleJDBCDAO;

    @Transactional
    @Override
    public Article saveArticle(Article article) {
        articleJDBCDAO.save(article);
        return article;
    }

    @Transactional
    @Override
    public void deleteArticle(long id) {
        articleJDBCDAO.deleteById(id);
    }

    @Transactional
    @Override
    public Article updateArticle(Article article) {
        articleJDBCDAO.updateById(article);
        return article;
    }

    @Override
    public Article getArticle(long id) {
        return articleJDBCDAO.findById(id);
    }

    @Override
    public List<Article> getAll() {
        return articleJDBCDAO.findAll();
    }
}
