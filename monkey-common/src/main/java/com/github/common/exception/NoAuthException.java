package com.github.common.exception;

import com.github.common.base.ResponseCode;

public class NoAuthException extends GlobalException {
	
	private static final long serialVersionUID = 7023923040870802290L;

	public NoAuthException(String message) {
		super(message, ResponseCode.NO_AUTH_CODE);
	}

}
