package com.github.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
/**
 * 注册中心启动入口
 * 
 * @author yinjihuan
 * 
 * @about http://cxytiandi.com/about
 * 
 * @date 2018-08-14
 * 
 */
@SpringBootApplication
@EnableEurekaServer
public class MonkeyEurekaApplication {
	public static void main(String[] args) {
		SpringApplication.run(MonkeyEurekaApplication.class, args);
	}
	
	@Configuration
	@EnableWebSecurity
	public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);
	        http.csrf().disable();
	        // 支持httpBasic
	        http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
	    }
	}
}

