package com.github.article.po;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;


/**
 * 文章对应的Mongodb实体类
 * 
 * @author yinjihuan
 * 
 * @about http://cxytiandi.com/about
 * 
 * @date 2018-08-17
 * 
 */
@Data
@Document(collection = "article")
public class Article {
	
	/**
	 * 文章ID
	 */
	@Id
	private String id;
	
	/**
	 * 标题
	 */
	@Field("title")
	private String title;
	
	/**
	 * 内容
	 */
	@Field("content")
	private String content;
	
	/**
	 * 标签
	 */
	@Field("tags")
	private List<String> tags;
	
	/**
	 * 添加时间
	 */
	@Field("a_time")
	private Date addTime;
	
	/**
	 * 更新时间
	 */
	@Field("u_time")
	private Date updateTime;
	
	/**
	 * 用户ID
	 */
	@Field("uid")
	private Long userId;
	
	/**
	 * 访问数量
	 */
	@Field("v_count")
	private Long visitCount;
	
	/**
	 * 文章类型（0:原创  1:转载  2:翻译）
	 */
	@Field("type")
	private int type;
	
	/**
	 * 是否删除
	 */
	@Field("r_status")
	private boolean removeStatus;
	
}
