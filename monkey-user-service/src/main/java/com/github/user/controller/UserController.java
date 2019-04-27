package com.github.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.common.base.Response;
import com.github.common.base.ResponseData;
import com.github.common.util.JWTUtils;
import com.github.user.dto.UserDto;
import com.github.user.dto.UserLoginDto;
import com.github.user.param.LoginParam;
import com.github.user.po.User;
import com.github.user.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value="用户控制器")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	public UserService userService;
	
	@ApiOperation(value = "用户登录")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK", response = UserLoginDto.class) })
	@PostMapping("/login")
	public ResponseData<UserLoginDto> login(@ApiParam(value = "登录参数", required = true) @RequestBody LoginParam param) {
		if (param == null) {
			return Response.failByParams("参数不能为空");
		}
		if (!StringUtils.hasText(param.getUsername())) {
			return Response.failByParams("username不能为空");
		}
		if (!StringUtils.hasText(param.getPass())) {
			return Response.failByParams("pass不能为空");
		}
		User user = userService.login(param);
		if (user == null) {
			return Response.failByParams("用户名或者密码错误");
		}
		String token = JWTUtils.getToken(user.getId().toString(), 60 * 60);
		UserLoginDto loginDto = UserLoginDto.builder().id(user.getId())
				.username(user.getUsername()).nickname(user.getNickname()).token(token).build();
		return Response.ok(loginDto);
	}

	@ApiOperation(value = "获取用户信息")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK", response = UserDto.class) })
	@GetMapping("/get")
	public ResponseData<UserDto> getUser(Long id) {
		if (id == null) {
			return Response.failByParams("id不能为空");
		}
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return Response.ok(userService.getUser(id));
	}
}
