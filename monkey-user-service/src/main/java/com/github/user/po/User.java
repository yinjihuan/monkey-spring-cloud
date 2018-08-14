package com.github.user.po;

import java.io.Serializable;
import java.util.Date;

import com.cxytiandi.jdbc.annotation.AutoId;
import com.cxytiandi.jdbc.annotation.Field;
import com.cxytiandi.jdbc.annotation.TableName;

import lombok.Data;

@Data
@TableName(value = "user", author = "yinjihuan", desc = "用户表")
public class User implements Serializable {

	private static final long serialVersionUID = 8584081529322786126L;

	@AutoId
	@Field(value = "id", desc = "用户ID")
	private Long id;
	
	@Field(value = "username", desc = "用户名")
	private String username;
	
	@Field(value = "pass", desc = "密码")
	private String pass;
	
	@Field(value = "nickname", desc = "昵称")
	private String nickname;
	
	@Field(value = "add_time", desc = "添加时间")
	private Date addTime;	
	
}
