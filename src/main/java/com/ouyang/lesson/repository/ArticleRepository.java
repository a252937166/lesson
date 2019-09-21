package com.ouyang.lesson.repository;

import com.ouyang.lesson.model.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


/**
 * @author ouyangduning
 */
public interface ArticleRepository extends ElasticsearchRepository<Article,String> {
}
