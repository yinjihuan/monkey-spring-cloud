package com.github.article;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

import com.spring4all.swagger.EnableSwagger2Doc;


/**
 * 文章服务启动入口
 * 
 * @author yinjihuan
 * 
 * @about http://cxytiandi.com/about
 * 
 * @date 2018-08-15
 * 
 */
@EnableHystrix
@EnableFeignClients(basePackages= {"com.github.feignclient"})
@ComponentScan(basePackages= {"com.github"})
@EnableSwagger2Doc
@SpringBootApplication
public class MonkeyArticleServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(MonkeyArticleServiceApplication.class, args);
	}
}
