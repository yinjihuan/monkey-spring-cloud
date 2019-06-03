package com.github.core.strategy;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@ConditionalOnProperty("zuul.discovery.strategy.enabled")
@Configuration
public class ZuulDiscoveryStrategyAutoConfiguration {

	@Bean
	public GrayInfo grayInfo() {
		return new GrayInfo();
	}
	
	@Bean
	public ZuulDiscoveryEnabledStrategy zuulDiscoveryEnabledStrategy() {
		return new ZuulDiscoveryEnabledStrategy();
	}
}
