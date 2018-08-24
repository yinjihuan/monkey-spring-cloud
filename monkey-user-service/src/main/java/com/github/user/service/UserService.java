package com.github.user.service;

import com.github.user.dto.UserDto;
import com.github.user.param.LoginParam;
import com.github.user.po.User;

public interface UserService {

	/**
	 * 用户登录
	 * 
	 * @author yinjihuan
	 * 
	 * @date 2018-08-14
	 * 
	 * @param param 登录参数
	 * 
	 * @return
	 */
	User login(LoginParam param);
	
	/**
	 * 获取用户信息
	 * 
	 * @author yinjihuan
	 * 
	 * @date 2018-08-24
	 * 
	 * @param id 用户ID
	 * 
	 * @return
	 */
	UserDto getUser(Long id);
	
}
