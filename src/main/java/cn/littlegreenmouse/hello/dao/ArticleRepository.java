package cn.littlegreenmouse.hello.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ArticleRepository extends PagingAndSortingRepository<Article, Long> {

    public Page<Article> findAll(Pageable pageable);

    public Page<Article> findByAuthor(String author, Pageable pageable);

    public Slice<Article> findByAuthorAndTitle(String author, String title, Pageable pageable);

}
