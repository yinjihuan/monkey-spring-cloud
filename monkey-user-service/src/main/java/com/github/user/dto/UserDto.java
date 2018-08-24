package com.github.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "com.github.user.dto.UserDto", description = "用户信息")
public class UserDto {
	
	@ApiModelProperty(value = "用户ID")
	private Long id;
	
	@ApiModelProperty(value = "用户名")
	private String username;
	
	@ApiModelProperty(value = "用户昵称")
	private String nickname;
	
}
