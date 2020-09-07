package com.es;

import com.es.model.Article;
import com.es.repository.ArticleRepository;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.document.Document;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    @Autowired
    ElasticsearchRestTemplate esRestTemplate;

    @Autowired
    ArticleRepository articleRepository;

    /*@Autowired
    IndexOperations indexOperations;*/

    @Override
    public void run(String... args) throws Exception {
        //esRestTemplate.indexOps(Article.class).create();
        /*esRestTemplate.save(new Article("dinesh", 30));
        */
        //custom query
        Query searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchQuery("name", "dinesh"))
                .build();
        SearchHits<Article> articles
                = esRestTemplate.search(searchQuery, Article.class, IndexCoordinates.of("myblog"));

        Article article = articles.getSearchHit(0).getContent();
        System.out.println(article.getAge()+" "+article.getId()+" "+article.getName());
    }
}
