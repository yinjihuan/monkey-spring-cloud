package com.github.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "com.github.user.dto.UserLoginDto", description = "用户登录返回信息")
public class UserLoginDto {

	@ApiModelProperty(value = "用户ID")
	private Long id;
	
	@ApiModelProperty(value = "用户昵称")
	private String nickname;
	
}
