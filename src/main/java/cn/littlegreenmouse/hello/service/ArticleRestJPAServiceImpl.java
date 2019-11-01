package cn.littlegreenmouse.hello.service;

import cn.littlegreenmouse.hello.jpa.springboot.Article;
import cn.littlegreenmouse.hello.jpa.springboot.ArticleRepository;
import cn.littlegreenmouse.hello.jpa.springboot2.Message;
import cn.littlegreenmouse.hello.jpa.springboot2.MessageRepository;
import cn.littlegreenmouse.hello.model.ArticleVO;
import cn.littlegreenmouse.hello.utils.DozerUtils;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ArticleRestJPAServiceImpl implements ArticleRestService{
    @Resource
    private ArticleRepository articleRepository;

    @Resource
    private MessageRepository messageRepository;

    @Resource
    private Mapper dozerMapper;

    @Override
    @Transactional
    public ArticleVO saveArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article, Article.class);
        articleRepository.save(articlePO);
        Message message = Message.builder().name("second").content("Hello world!").build();
        messageRepository.save(message);
        // int a = 2 / 0;
        return article;
    }

    @Override
    public void deleteArticle(long id) {
        articleRepository.deleteById(id);
    }

    @Override
    public void updateArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article, Article.class);
        articleRepository.save(articlePO);
    }

    @Override
    public ArticleVO getArticle(long id) {
        Optional<Article> article = articleRepository.findById(id);
        return dozerMapper.map(article.get(), ArticleVO.class);
    }

    @Override
    public List<ArticleVO> getAll() {
        List<Article> articles = articleRepository.findAll();
        return DozerUtils.mapList(articles, ArticleVO.class);
    }
}
