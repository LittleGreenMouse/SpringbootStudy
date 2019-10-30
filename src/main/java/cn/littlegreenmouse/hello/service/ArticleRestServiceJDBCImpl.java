package cn.littlegreenmouse.hello.service;


import cn.littlegreenmouse.hello.dao.ArticleJDBCDAO;
import cn.littlegreenmouse.hello.model.Article;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticleRestServiceJDBCImpl implements ArticleRestService {
    @Resource
    private ArticleJDBCDAO articleJDBCDAO;

    @Resource
    private JdbcTemplate primaryJdbcTemplate;

    @Resource
    private JdbcTemplate secondaryJdbcTemplate;

    @Override
    @Transactional
    public Article saveArticle(Article article) {
        articleJDBCDAO.save(article, primaryJdbcTemplate);
        articleJDBCDAO.save(article, secondaryJdbcTemplate);
        // int a = 2 / 0;
        return article;
    }

    @Transactional
    @Override
    public void deleteArticle(long id) {
        articleJDBCDAO.deleteById(id, primaryJdbcTemplate);
    }

    @Transactional
    @Override
    public Article updateArticle(Article article) {
        articleJDBCDAO.updateById(article, primaryJdbcTemplate);
        return article;
    }

    @Override
    public Article getArticle(long id) {
        return articleJDBCDAO.findById(id, primaryJdbcTemplate);
    }

    @Override
    public List<Article> getAll() {
        return articleJDBCDAO.findAll(primaryJdbcTemplate);
    }
}
