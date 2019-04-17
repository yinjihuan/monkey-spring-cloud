package com.github.common.exception;

import com.github.common.base.ResponseCode;

public class GlobalException extends RuntimeException {
	
	private static final long serialVersionUID = -5701182284190108797L;
	
	private ResponseCode code;

	public void setCode(ResponseCode code) {
		this.code = code;
	}

	public ResponseCode getCode() {
		return code;
	}

	public GlobalException(String message) {
		super(message);
	}

	public GlobalException(String message, ResponseCode code) {
		super(message);
		this.code = code;
	}

}
