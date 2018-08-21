package com.github.article.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.github.article.po.Article;
import com.mongodb.bulk.UpdateRequest;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

@Repository
public class ArticleServiceDaoImpl implements ArticleServiceDao {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public String saveArticle(Article article) {
		mongoTemplate.save(article);
		return article.getId();
	}

	public Article getArticle(String id) {
		return mongoTemplate.findOne(Query.query(Criteria.where("id").is(id)), Article.class);
	}

	public boolean deleteArticle(String id) {
		UpdateResult result = mongoTemplate.updateFirst(
				Query.query(Criteria.where("id").is(id)), 
				Update.update("removeStatus", true), Article.class);
		return result.getModifiedCount() == 1 ? true : false;
	}

}
