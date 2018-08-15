package com.github.user.exception;


import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.common.base.Response;
import com.github.common.base.ResponseCode;
import com.github.common.base.ResponseData;

/**
 * 全局异常处理
 * 
 * @author yinjihuan
 * 
 * @about http://cxytiandi.com/about
 * 
 * @date 2018-08-15
 * 
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	/**
	 * 系统异常处理，比如：404,500
	 * @param req
	 * @param e
	 * @return
	 * @throws Exception
	 */
	@ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseData<Object> defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        if (e instanceof org.springframework.web.servlet.NoHandlerFoundException) {
        	return Response.fail(e.getMessage(), ResponseCode.NOT_FOUND);
		} else {
			logger.error("monkey-user-service异常", e);
			return Response.fail(e.getMessage(), ResponseCode.SERVER_ERROR_CODE);
		}
    }
}
