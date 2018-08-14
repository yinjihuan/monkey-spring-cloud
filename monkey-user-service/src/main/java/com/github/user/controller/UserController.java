package com.github.user.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.common.base.Response;
import com.github.common.base.ResponseData;
import com.github.user.po.User;
import com.github.user.query.LoginQuery;

@RestController
@RequestMapping("/user")
public class UserController {

	@PostMapping("/login")
	public ResponseData<User> login(@RequestBody LoginQuery query) {
		User user = new User();
		user.setUsername("yinjihuan");
		return Response.ok(user);
	}

}
