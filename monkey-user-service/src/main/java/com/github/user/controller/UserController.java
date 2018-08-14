package com.github.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.common.base.Response;
import com.github.common.base.ResponseData;
import com.github.user.param.LoginParam;
import com.github.user.po.User;
import com.github.user.service.impl.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public ResponseData<User> login(@RequestBody LoginParam param) {
		if (param == null) {
			return Response.fail("参数不能为空");
		}
		if (!StringUtils.hasText(param.getUsername())) {
			return Response.fail("username不能为空");
		}
		if (!StringUtils.hasText(param.getPass())) {
			return Response.fail("pass不能为空");
		}
		User user = userService.login(param);
		if (user == null) {
			return Response.fail("用户名或者密码错误");
		}
		return Response.ok(user);
	}

}
