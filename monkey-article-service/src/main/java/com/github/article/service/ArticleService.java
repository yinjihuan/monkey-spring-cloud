package com.github.article.service;

import java.util.List;

import com.github.article.dto.ArticleDto;
import com.github.article.po.Article;
/**
 * 文章业务
 * 
 * @author yinjihuan
 * 
 * @about http://cxytiandi.com/about
 * 
 * @date 2018-08-25
 * 
 */
public interface ArticleService {

	/**
	 * 保存文章
	 * 
	 * @author yinjihuan
	 * 
	 * @param article 文章信息对象
	 * 
	 * @return 新增之后的文章ID
	 */
	String saveArticle(Article article);
	
	/**
	 * 查询文章信息
	 * 
	 * @author yinjihuan
	 * 
	 * @param id 文章ID
	 * 
	 * @return 文章信息
	 */
	ArticleDto getArticle(String id);
	
	/**
	 * 删除文章
	 * 
	 * @author yinjihuan
	 * 
	 * @param id 文章ID
	 * 
	 * @return 成功或者失败
	 */
	boolean deleteArticle(String id);
	
	/**
	 * 修改文章
	 * 
	 * @author yinjihuan
	 * 
	 * @param article 文章信息对象
	 * 
	 * @return 成功或者失败
	 */
	boolean updateArticle(Article article);
	
	/**
	 * 查询用户的文章信息
	 * 
	 * @author yinjihuan
	 * 
	 * @param userId 用户ID
	 * 
	 * @return 文章信息
	 */
	List<ArticleDto> queryArticleByUser(Long userId);
	
	/**
	 * 增加文章浏览量
	 * 
	 * @author yinjihuan
	 * 
	 * @param id 文章ID
	 * 
	 * @return 增加之后的浏览量
	 */
	Long addArticleVisitCount(String id);
}
