package cn.littlegreenmouse.hello.jpa.springboot;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    public List<Article> findByAuthor(String author);

}
