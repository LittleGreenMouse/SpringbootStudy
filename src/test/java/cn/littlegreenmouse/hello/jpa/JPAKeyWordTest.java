package cn.littlegreenmouse.hello.jpa;

import cn.littlegreenmouse.hello.dao.ArticleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JPAKeyWordTest {

    @Resource
    private ArticleRepository articleRepository;

    @Test
    public void userTest() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("id"));
        System.out.println(articleRepository.findByAuthor("LittleMouse", pageable).getContent());
    }
}
