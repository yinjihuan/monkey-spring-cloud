package com.github.article.config;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.core.feign.FeignBasicAuthRequestInterceptor;
import com.github.core.filter.HttpHeaderParamFilter;
import com.github.core.threadlocal.ThreadLocalHystrixConcurrencyStrategy;
import com.netflix.hystrix.strategy.HystrixPlugins;

@Configuration
public class BeanConfig {
	
	@Bean
	public FilterRegistrationBean<HttpHeaderParamFilter> filterRegistrationBean() {
		FilterRegistrationBean<HttpHeaderParamFilter> registrationBean = new FilterRegistrationBean<HttpHeaderParamFilter>();
		HttpHeaderParamFilter httpHeaderParamFilter = new HttpHeaderParamFilter();
		registrationBean.setFilter(httpHeaderParamFilter);
		List<String> urlPatterns = new ArrayList<String>(1);
		urlPatterns.add("/*");
		registrationBean.setUrlPatterns(urlPatterns);
		return registrationBean;
	}

	@Bean
	public FeignBasicAuthRequestInterceptor basicAuthRequestInterceptor() {
		return new FeignBasicAuthRequestInterceptor();
	}
	
	@PostConstruct
	public void init() {
		//注册自定义线程池
		HystrixPlugins.getInstance().registerConcurrencyStrategy(new ThreadLocalHystrixConcurrencyStrategy());
	}
}
