package com.github.core.exception;


import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.common.base.Response;
import com.github.common.base.ResponseCode;
import com.github.common.base.ResponseData;
import com.github.common.exception.GlobalException;

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
        	return Response.fail(e.getMessage(), ResponseCode.NOT_FOUND_CODE);
		} else if (e instanceof MethodArgumentNotValidException) {
			// 注解验证参数异常
			MethodArgumentNotValidException exception = (MethodArgumentNotValidException) e;
			BindingResult bindResult = exception.getBindingResult();
			String message = bindResult.getAllErrors().stream().map(s -> s.getDefaultMessage()).collect(Collectors.joining(","));
			return Response.fail(message, ResponseCode.PARAM_ERROR_CODE);
		} else {
			logger.error("异常", e);
			return Response.fail(e.getMessage(), ResponseCode.SERVER_ERROR_CODE);
		}
    }
	
	/**
	 * 自定义异常处理
	 * @param req
	 * @param e
	 * @return
	 * @throws Exception
	 */
	@ExceptionHandler(value = GlobalException.class)
    @ResponseBody
    public ResponseData<Object>customerErrorHandler(HttpServletRequest req, GlobalException e) throws Exception {
		return Response.fail(e.getMessage(), e.getCode());
    }
}
