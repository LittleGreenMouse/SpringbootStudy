package cn.littlegreenmouse.hello.service;

import cn.littlegreenmouse.hello.dao.Article;
import cn.littlegreenmouse.hello.dao.ArticleRepository;
import cn.littlegreenmouse.hello.model.ArticleVO;
import cn.littlegreenmouse.hello.utils.DozerUtils;
import org.dozer.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        Pageable pageable = PageRequest.of(0, 10, Sort.by("id"));
        Page<Article> articlePage = articleRepository.findAll(pageable);
        return DozerUtils.mapList(articlePage.getContent(), ArticleVO.class);
    }
}
