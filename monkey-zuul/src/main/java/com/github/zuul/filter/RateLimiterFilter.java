package com.github.zuul.filter;

import org.springframework.stereotype.Component;

import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

@Component
public class RateLimiterFilter extends ZuulFilter {

	private RateLimiter rateLimiter = RateLimiter.create(1.0);
	
	@ApolloConfigChangeListener(interestedKeys= "rateLimiter")
	public void updateRateLimiter(ConfigChangeEvent changeEvent) {
		String rateLimiterNewValue = changeEvent.getChange("rateLimiter").getNewValue();
		System.out.println("修改速率："+rateLimiterNewValue);
		rateLimiter.setRate(Double.parseDouble(rateLimiterNewValue));
	}
	
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		rateLimiter.acquire();
//		if (rateLimiter.tryAcquire()) {
//			System.err.println("获取到了");
//		}
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
