package com.github.article.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.article.dao.ArticleServiceDao;
import com.github.article.dto.ArticleDto;
import com.github.article.po.Article;
import com.github.article.service.ArticleService;
import com.github.common.base.ResponseData;
import com.github.common.exception.ParamException;
import com.github.feignclient.user.UserRemoteClient;
import com.github.feignclient.user.dto.UserDto;

import brave.ScopedSpan;
import brave.Tracer;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	private ArticleServiceDao articleServiceDao;

	@Autowired
	private UserRemoteClient userRemoteClient;
	
	@Autowired
	Tracer tracer;
	
	public String saveArticle(Article article) {
		article.setAddTime(new Date());
		return articleServiceDao.saveArticle(article);
	}

	public ArticleDto getArticle(String id) {
		ArticleDto articleDto = new ArticleDto();
		//ScopedSpan span = tracer.startScopedSpan("xx查询");
		//span.annotate("1001");
//		try {
//			Thread.sleep(200);
//		} catch (Exception | Error e) {
//			span.error(e);
//		} finally {
//			span.finish(); 
//		}
//		Article article = articleServiceDao.getArticle("5cb87ca3b42b013a567f8fea");
//		if (article == null) {
//			return null;
//		}
		Article article = new Article();
		article.setUserId(1L);
		BeanUtils.copyProperties(article, articleDto);
		ResponseData<UserDto> responseData = userRemoteClient.getUser(article.getUserId());
		if (responseData.isOk()) {
			String username = responseData.getData().getUsername();
			articleDto.setUsername(username);
		}
		return articleDto;
	}

	public boolean deleteArticle(String id) {
		return articleServiceDao.deleteArticle(id);
	}

	public boolean updateArticle(Article article) {
		return articleServiceDao.updateArticle(article);
	}

	public List<ArticleDto> queryArticleByUser(Long userId) {
		if (userId == null) {
			throw new ParamException("userId不能为空");
		}
		List<ArticleDto> datas = new ArrayList<ArticleDto>();
		List<Article> articleList = articleServiceDao.queryArticleByUser(userId);
		for (Article article : articleList) {
			ArticleDto articleDto = new ArticleDto();
			BeanUtils.copyProperties(article, articleDto);
			datas.add(articleDto);
		}
		return datas;
	}

	public Long addArticleVisitCount(String id) {
		boolean result = articleServiceDao.addArticleVisitCount(id);
		if (!result) {
			return null;
		}
		Article article = articleServiceDao.getArticle(id);
		if (article == null) return null;
		return article.getVisitCount();
	}
	
}
