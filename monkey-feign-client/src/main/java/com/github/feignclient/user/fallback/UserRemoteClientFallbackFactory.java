package com.github.feignclient.user.fallback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.github.common.base.Response;
import com.github.common.base.ResponseCode;
import com.github.common.base.ResponseData;
import com.github.feignclient.user.UserRemoteClient;
import com.github.feignclient.user.dto.UserDto;

import feign.hystrix.FallbackFactory;

@Component
public class UserRemoteClientFallbackFactory implements FallbackFactory<UserRemoteClient> {
	private Logger logger = LoggerFactory.getLogger(UserRemoteClientFallbackFactory.class);
	
	@Override
	public UserRemoteClient create(Throwable cause) {
		
		return new UserRemoteClient() {
			
			@Override
			public ResponseData<UserDto> getUser(Long id) {
				logger.error("UserRemoteClient.getUser异常", cause);
				return Response.fail(cause.getMessage(), ResponseCode.FALLBACK);
			}
		};
	}

}
