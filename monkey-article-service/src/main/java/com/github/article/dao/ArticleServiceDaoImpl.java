package com.github.article.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.github.article.po.Article;

@Repository
public class ArticleServiceDaoImpl implements ArticleServiceDao {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public String saveArticle(Article article) {
		mongoTemplate.save(article);
		return article.getId();
	}

}
