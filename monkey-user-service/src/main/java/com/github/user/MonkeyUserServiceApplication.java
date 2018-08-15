package com.github.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
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
public class MonkeyUserServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(MonkeyUserServiceApplication.class, args);
	}
}