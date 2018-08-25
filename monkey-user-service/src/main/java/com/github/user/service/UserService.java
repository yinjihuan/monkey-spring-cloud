package com.github.user.service;

import com.github.user.dto.UserDto;
import com.github.user.param.LoginParam;
import com.github.user.po.User;
/**
 * 用户业务
 * 
 * @author yinjihuan
 * 
 * @about http://cxytiandi.com/about
 * 
 * @date 2018-08-25
 * 
 */
public interface UserService {

	/**
	 * 用户登录
	 * 
	 * @author yinjihuan
	 * 
	 * @param param 登录参数
	 * 
	 * @return 登录之后的用户信息
	 */
	User login(LoginParam param);
	
	/**
	 * 获取用户信息
	 * 
	 * @author yinjihuan
	 * 
	 * @param id 用户ID
	 * 
	 * @return 用户信息
	 */
	UserDto getUser(Long id);
	
}
