package com.github.article.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.github.article.po.Article;
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

	public boolean updateArticle(Article article) {
		Update update = Update.update("title", article.getTitle())
				.set("content", article.getContent())
				.set("tags", article.getTags())
				.set("type", article.getType())
				.set("updateTime", new Date());
		UpdateResult result = mongoTemplate.updateFirst(
				Query.query(Criteria.where("id").is(article.getId())), update, Article.class);
		return result.getModifiedCount() == 1 ? true : false;
	}

	public List<Article> queryArticleByUser(Long userId) {
		return mongoTemplate.find(Query.query(Criteria.where("userId").is(userId)), Article.class);
	}

	public boolean addArticleVisitCount(String id) {
		UpdateResult result = mongoTemplate.updateFirst(Query.query(Criteria.where("id").is(id)), 
				new Update().inc("visitCount", 1), Article.class);
		return result.getModifiedCount() == 1 ? true : false;
	}

}
