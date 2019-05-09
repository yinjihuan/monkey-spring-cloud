package com.github.user.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.cxytiandi.jdbc.EntityService;
import com.github.user.dto.UserDto;
import com.github.user.param.LoginParam;
import com.github.user.po.User;
import com.github.user.service.UserService;

@Service
public class UserServiceImpl extends EntityService<User> implements UserService {

	public User login(LoginParam param) {
		if (param.getUsername().equals("yinjihuan") && param.getPass().equals("123456")) {
			User user = new User();
			user.setId(1L);
			user.setUsername("yinjihuan");
			user.setNickname("猿天地");
			user.setAddTime(new Date());
			return user;
		}
		return null;
		//return super.getByParams(new String[] { "username", "pass" }, new Object[] { param.getUsername(), param.getPass() });
	}

	public UserDto getUser(Long id) {
		User user = super.getById("id", id);
		if (user == null) {
			return null;
		}
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(user, userDto);
		return userDto;
	}

}
