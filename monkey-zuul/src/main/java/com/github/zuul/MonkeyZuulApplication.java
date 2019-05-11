package com.github.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
/**
 * 网关启动入口
 * 
 * @author yinjihuan
 * 
 * @about http://cxytiandi.com/about
 * 
 * @date 2018-08-14
 * 
 */
@EnableCreateCacheAnnotation
@EnableZuulProxy
@SpringBootApplication
public class MonkeyZuulApplication {
	public static void main(String[] args) {
		SpringApplication.run(MonkeyZuulApplication.class, args);
	}
}
