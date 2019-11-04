package cn.littlegreenmouse.hello.service;

import cn.littlegreenmouse.hello.generator.springboot.Article;
import cn.littlegreenmouse.hello.generator.springboot.ArticleMapper;
import cn.littlegreenmouse.hello.generator.springboot2.Message;
import cn.littlegreenmouse.hello.generator.springboot2.MessageMapper;
import cn.littlegreenmouse.hello.model.ArticleVO;
import cn.littlegreenmouse.hello.utils.DozerUtils;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class ArticleMybatisRestServiceImpl implements ArticleRestService{
    @Resource
    protected Mapper dozerMapper;

    @Resource
    private ArticleMapper articleMapper;

    @Resource
    private MessageMapper messageMapper;

    @Override
    @Transactional
    public ArticleVO saveArticle(ArticleVO articleVO) {
        Article article = dozerMapper.map(articleVO, Article.class);
        articleMapper.insert(article);
        Message message = new Message();
        message.setName("first");
        message.setContent("test text");
        messageMapper.insert(message);

        int a = 1 / 0;

        return articleVO;
    }

    @Override
    public void deleteArticle(long id) {
        articleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateArticle(ArticleVO articleVO) {
        Article article = dozerMapper.map(articleVO, Article.class);
        articleMapper.updateByPrimaryKeySelective(article);
    }

    @Override
    public ArticleVO getArticle(long id) {
        return dozerMapper.map(articleMapper.selectByPrimaryKey(id), ArticleVO.class);
    }

    @Override
    public List<ArticleVO> getAll() {
        return DozerUtils.mapList(articleMapper.selectByExample(null), ArticleVO.class);
    }
}
