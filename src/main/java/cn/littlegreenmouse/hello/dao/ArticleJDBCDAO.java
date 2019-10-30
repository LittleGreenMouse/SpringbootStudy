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
    private JdbcTemplate jdbcTemplate;

    public void save(Article article) {
        jdbcTemplate.update(
                "insert into " +
                        "article(author, title, content, create_time) " +
                        "values(?,?,?,?)",
                article.getAuthor(),
                article.getTitle(),
                article.getContent(),
                article.getCreateTime());
    }

    public void deleteById(long id) {
        jdbcTemplate.update(
                "delete from article " +
                        "where id = ?",
                new Object[]{id});
    }

    public void updateById(Article article) {
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

    public Article findById(long id) {
        return (Article) jdbcTemplate.queryForObject(
                "select * " +
                        "from article " +
                        "where id = ?",
                new Object[]{id},
                new BeanPropertyRowMapper(Article.class));
    }

    public List<Article> findAll() {
        return (List<Article>) jdbcTemplate.query(
                "select * " +
                        "from article",
                new BeanPropertyRowMapper(Article.class));
    }
}
