package com.github.article.service;

import com.github.article.dto.ArticleDto;
import com.github.article.po.Article;

public interface ArticleService {

	/**
	 * 保存文章
	 * @param  article	文章信息对象
	 * @return 新增之后的文章ID
	 */
	String saveArticle(Article article);
	
	/**
	 * 查询文章信息
	 * @param id	文章ID
	 * @return
	 */
	ArticleDto getArticle(String id);
	
	/**
	 * 删除文章
	 * @param id	文章ID
	 * @return
	 */
	boolean deleteArticle(String id);
}
