package com.github.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ApiModel(value = "com.github.user.dto.UserLoginDto", description = "用户登录返回信息")
public class UserLoginDto {

	@ApiModelProperty(value = "用户ID")
	private Long id;
	
	@ApiModelProperty(value = "用户名")
	private String username;
	
	@ApiModelProperty(value = "用户昵称")
	private String nickname;
	
	@ApiModelProperty(value = "登录成功的标识")
	private String token;
	
}
