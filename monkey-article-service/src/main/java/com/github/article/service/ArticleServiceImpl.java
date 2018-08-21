package com.github.article.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.article.dao.ArticleServiceDao;
import com.github.article.dto.ArticleDto;
import com.github.article.po.Article;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	private ArticleServiceDao articleServiceDao;

	public String saveArticle(Article article) {
		article.setAddTime(new Date());
		return articleServiceDao.saveArticle(article);
	}

	public ArticleDto getArticle(String id) {
		ArticleDto articleDto = new ArticleDto();
		Article article = articleServiceDao.getArticle(id);
		if (article == null) {
			return null;
		}
		BeanUtils.copyProperties(article, articleDto);
		return articleDto;
	}

	public boolean deleteArticle(String id) {
		return articleServiceDao.deleteArticle(id);
	}

	public boolean updateArticle(Article article) {
		return articleServiceDao.updateArticle(article);
	}

	public List<ArticleDto> queryArticleByUser(Long userId) {
		List<ArticleDto> datas = new ArrayList<ArticleDto>();
		List<Article> articleList = articleServiceDao.queryArticleByUser(userId);
		for (Article article : articleList) {
			ArticleDto articleDto = new ArticleDto();
			BeanUtils.copyProperties(article, articleDto);
			datas.add(articleDto);
		}
		return datas;
	}
	
}
