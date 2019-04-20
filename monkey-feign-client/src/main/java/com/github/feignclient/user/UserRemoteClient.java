package com.github.feignclient.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.common.base.ResponseData;
import com.github.feignclient.user.dto.UserDto;
import com.github.feignclient.user.fallback.UserRemoteClientFallbackFactory;

@FeignClient(value = "user-service", fallbackFactory = UserRemoteClientFallbackFactory.class)
public interface UserRemoteClient {
	
	@GetMapping("/user/get")
	public ResponseData<UserDto> getUser(@RequestParam("id") Long id);
	
}
