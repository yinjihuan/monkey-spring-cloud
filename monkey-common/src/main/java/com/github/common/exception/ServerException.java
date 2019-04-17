package com.github.common.exception;

import com.github.common.base.ResponseCode;

public class ServerException extends GlobalException {
	
	private static final long serialVersionUID = -8967695202238540345L;

	public ServerException(String message) {
		super(message, ResponseCode.SERVER_ERROR_CODE);
	}

}
