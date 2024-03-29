package cn.littlegreenmouse.hello.mybatis;

import cn.littlegreenmouse.hello.generator.springboot.Article;
import cn.littlegreenmouse.hello.generator.springboot.ArticleMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisTest {
    @Resource
    ArticleMapper articleMapper;

    @Test
    public void testPageHelper() {
        PageHelper.startPage(1, 2);
        List<Article> articles = articleMapper.selectByExample(null);
        PageInfo<Article> page = PageInfo.of(articles);
        System.out.println(page);
    }
}
