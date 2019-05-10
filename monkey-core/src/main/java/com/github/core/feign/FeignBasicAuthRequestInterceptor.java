package com.github.core.feign;

import java.util.Map;

import com.github.common.support.RibbonFilterContextHolder;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * 传递用户信息到被调用的服务
 * 
 * @author yinjihuan
 *
 */
public class FeignBasicAuthRequestInterceptor implements RequestInterceptor {
	public FeignBasicAuthRequestInterceptor() {

	}

	@Override
	public void apply(RequestTemplate template) {
		System.err.println(Thread.currentThread().getName());
		Map<String, String> attributes = RibbonFilterContextHolder.getCurrentContext().getAttributes();
		for (String key : attributes.keySet()) {
			String value = attributes.get(key);
			System.err.println("===="+Thread.currentThread().getName() + "\t" + key + "\t" + value);
			template.header(key, value);
		}
		RibbonFilterContextHolder.clearCurrentContext();
	}

}