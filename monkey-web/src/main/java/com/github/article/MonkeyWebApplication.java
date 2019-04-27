package com.github.article;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 前端启动入口
 * 
 * @author yinjihuan
 * 
 * @about http://cxytiandi.com/about
 * 
 * @date 2019-04-27
 * 
 */
@Controller
@SpringBootApplication
public class MonkeyWebApplication {
	public static void main(String[] args) {
		SpringApplication.run(MonkeyWebApplication.class, args);
	}
	
	@GetMapping("/")
	public String indexPage() {
		return "index";
	}
	
	@GetMapping("/test")
	public String testPage() {
		return "index";
	}
	
}
