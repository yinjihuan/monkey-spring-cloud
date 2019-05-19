package com.github.zuul.config;

import org.springframework.beans.BeansException;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;

@Component
public class RateLimterPropertiesRefresher implements ApplicationContextAware {

	 private ApplicationContext applicationContext;
	 
	 @ApolloConfigChangeListener
	  public void onChange(ConfigChangeEvent changeEvent) {
		 // 刷新@ConfigurationProperties中的值
		 this.applicationContext.publishEvent(new EnvironmentChangeEvent(changeEvent.changedKeys()));
	  }
	 
	 @Override
	  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
	    this.applicationContext = applicationContext;
	  }
}
