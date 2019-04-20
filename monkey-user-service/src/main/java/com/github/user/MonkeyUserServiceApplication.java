package com.github.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

import com.spring4all.swagger.EnableSwagger2Doc;
/**
 * 用户服务启动入口
 * 
 * @author yinjihuan
 * 
 * @about http://cxytiandi.com/about
 * 
 * @date 2018-08-14
 * 
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2Doc
@ComponentScan(basePackages= {"com.github"})
public class MonkeyUserServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(MonkeyUserServiceApplication.class, args);
	}
}