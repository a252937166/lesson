package com.ouyang.lesson.repository;

import com.ouyang.lesson.model.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ouyangduning
 */
public interface ArticleRepository extends ElasticsearchRepository<Article,String> {

    Article queryArticleById(String id);

    List<Article> findByTitle(String title);
}
