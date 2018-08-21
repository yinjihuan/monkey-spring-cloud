package com.github.article.dto;

import java.util.Date;
import java.util.List;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "com.github.article.dto.ArticleDto", description = "查询文章返回信息")
public class ArticleDto {
	
	@ApiModelProperty(value = "文章ID")
	private String id;
	
	@ApiModelProperty(value = "标题")
	private String title;
	
	@ApiModelProperty(value = "内容")
	private String content;
	
	@ApiModelProperty(value = "标签")
	private List<String> tags;
	
	@ApiModelProperty(value = "添加时间")
	private Date addTime;
	
	@ApiModelProperty(value = "用户ID")
	private Long userId;
	
	@ApiModelProperty(value = "访问数量")
	private Long visitCount;
	
	@ApiModelProperty(value = "文章类型（0:原创  1:转载  2:翻译）")
	private int type; 
	
	@ApiModelProperty(value = "是否删除")
	private boolean removeStatus;
}
