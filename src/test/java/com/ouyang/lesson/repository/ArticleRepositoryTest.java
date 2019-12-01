package com.ouyang.lesson.repository;

import com.ouyang.lesson.LessionApplicationTests;
import com.ouyang.lesson.model.Article;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;

import java.util.Optional;


/**
 * @author ouyangduning3
 * @date 2019/9/21 18:17
 */
public class ArticleRepositoryTest extends LessionApplicationTests {

    public ArticleRepositoryTest() {
        System.setProperty("es.set.netty.runtime.available.processors", "false");
    }

    @Autowired
    private ArticleRepository articleRepository;

    /**
     * 根据id查询
     */
    @Test
    public void queryArticleById() {
        Optional<Article> article = articleRepository.findById("1");
        Assert.assertNotNull(article);
        System.out.println(article.get());
    }

    /**
     * 模糊查询
     */
    @Test
    public void search() {
        SearchQuery searchQuery=getEntitySearchQuery(0,3,"文章");
        Page<Article> page = articleRepository.search(searchQuery);
        Assert.assertNotNull(page);
        for (Article a : page.getContent()) {
            System.out.println(a);
        }
    }

    /**
     * 新增
     */
    @Test
    public void save() {
        Article article = new Article();
        article.setTitle("文章新增");
        article.setDesc("3232323");
        Article save = articleRepository.save(article);
        Assert.assertNotNull(save);
    }

    private SearchQuery getEntitySearchQuery(int pageNumber, int pageSize, String searchContent) {
        QueryBuilder queryBuilder = QueryBuilders.multiMatchQuery(searchContent, "title", "desc");
        // 设置分页
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return new NativeSearchQueryBuilder()
                .withPageable(pageable)
                .withQuery(queryBuilder).build();
    }

}