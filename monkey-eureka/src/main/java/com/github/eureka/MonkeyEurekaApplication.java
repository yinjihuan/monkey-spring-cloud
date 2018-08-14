package com.github.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
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
@SpringBootApplication
@EnableEurekaServer
public class MonkeyEurekaApplication {
	public static void main(String[] args) {
		SpringApplication.run(MonkeyEurekaApplication.class, args);
	}
}

