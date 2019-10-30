package cn.littlegreenmouse.hello.dao;

import cn.littlegreenmouse.hello.model.Article;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class ArticleJDBCDAO {
    @Resource
    private JdbcTemplate primaryJdbcTemplate;

    public void save(Article article, JdbcTemplate jdbcTemplate) {
        if(jdbcTemplate == null)    jdbcTemplate = primaryJdbcTemplate;
        jdbcTemplate.update(
                "insert into " +
                        "article(author, title, content, create_time) " +
                        "values(?,?,?,?)",
                article.getAuthor(),
                article.getTitle(),
                article.getContent(),
                article.getCreateTime());
    }

    public void deleteById(long id, JdbcTemplate jdbcTemplate) {
        if(jdbcTemplate == null)    jdbcTemplate = primaryJdbcTemplate;
        jdbcTemplate.update(
                "delete from article " +
                        "where id = ?",
                new Object[]{id});
    }

    public void updateById(Article article, JdbcTemplate jdbcTemplate) {
        if(jdbcTemplate == null)    jdbcTemplate = primaryJdbcTemplate;
        jdbcTemplate.update(
                "update article " +
                        "set author = ?, title = ?, content = ?, create_time = ? " +
                        "where id = ?",
                article.getAuthor(),
                article.getTitle(),
                article.getContent(),
                article.getCreateTime(),
                article.getId());
    }

    public Article findById(long id, JdbcTemplate jdbcTemplate) {
        if(jdbcTemplate == null)    jdbcTemplate = primaryJdbcTemplate;
        return (Article) jdbcTemplate.queryForObject(
                "select * " +
                        "from article " +
                        "where id = ?",
                new Object[]{id},
                new BeanPropertyRowMapper(Article.class));
    }

    public List<Article> findAll(JdbcTemplate jdbcTemplate) {
        if(jdbcTemplate == null)    jdbcTemplate = primaryJdbcTemplate;
        return (List<Article>) jdbcTemplate.query(
                "select * " +
                        "from article",
                new BeanPropertyRowMapper(Article.class));
    }
}
