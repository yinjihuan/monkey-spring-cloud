package com.github.zuul.error;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import com.github.common.base.Response;
import com.github.common.base.ResponseCode;
import com.github.common.base.ResponseData;

@RestController
public class ErrorHandlerController implements ErrorController {

	@Autowired
	private ErrorAttributes errorAttributes;

	@Override
	public String getErrorPath() {
		return "/error";
	}

	@RequestMapping("/error")
	public ResponseData<Object> error(HttpServletRequest request) {
		Map<String, Object> errorAttributes = getErrorAttributes(request);
		String message = (String) errorAttributes.get("message");
		String trace = (String) errorAttributes.get("trace");
		if (StringUtils.isNotBlank(trace)) {
			message += String.format(" and trace %s", trace);
		}
		int status = Integer.parseInt(errorAttributes.get("status").toString());
		if (status == 404) {
			return Response.fail(message, ResponseCode.NOT_FOUND_CODE);
		} 
		return Response.fail(message, ResponseCode.SERVER_ERROR_CODE);
	}

	private Map<String, Object> getErrorAttributes(HttpServletRequest request) {
		return errorAttributes.getErrorAttributes(new ServletWebRequest(request), true);
	}

}
