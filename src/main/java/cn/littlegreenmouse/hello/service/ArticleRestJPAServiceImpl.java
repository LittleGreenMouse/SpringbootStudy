package cn.littlegreenmouse.hello.service;

import cn.littlegreenmouse.hello.dao.Article;
import cn.littlegreenmouse.hello.dao.ArticleRepository;
import cn.littlegreenmouse.hello.model.ArticleVO;
import cn.littlegreenmouse.hello.utils.DozerUtils;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleRestJPAServiceImpl implements ArticleRestService{
    @Resource
    private ArticleRepository articleRepository;

    @Resource
    private Mapper dozerMapper;

    @Override
    public ArticleVO saveArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article, Article.class);
        articleRepository.save(articlePO);
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
