package cn.littlegreenmouse.hello.jdbc;

import cn.littlegreenmouse.hello.dao.ArticleJDBCDAO;
import cn.littlegreenmouse.hello.model.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringJdbcTest {

    @Resource
    private ArticleJDBCDAO articleJDBCDAO;
    @Resource
    private JdbcTemplate primaryJdbcTemplate;
    @Resource
    private JdbcTemplate secondaryJdbcTemplate;

    @Test
    public void testJdbc() {
        articleJDBCDAO.save(
                Article.builder()
                        .author("LGM")
                        .title("Test1")
                        .content("primary test text")
                        .createTime(new Date())
                        .build(),
                primaryJdbcTemplate);
        articleJDBCDAO.save(
                Article.builder()
                        .author("LittleMouse")
                        .title("test")
                        .content("secondary test text")
                        .createTime(new Date())
                        .build(),
                secondaryJdbcTemplate);
    }
}
