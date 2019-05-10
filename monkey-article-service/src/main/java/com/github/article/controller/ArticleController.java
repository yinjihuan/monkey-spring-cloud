package com.github.article.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.github.article.dto.ArticleDto;
import com.github.article.po.Article;
import com.github.article.service.ArticleService;
import com.github.common.base.Response;
import com.github.common.base.ResponseData;
import com.github.common.util.JWTUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "文章控制器")
@RestController
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	private ArticleService articleService;

	@Autowired
	private HttpServletRequest request;

	@ApiOperation(value = "添加文章")
	@PostMapping("/add")
	public ResponseData<String> addArticle(@Valid @RequestBody Article article) {
//		if (article == null) {
//			return Response.failByParams("参数不能为空");
//		}
//		if (!StringUtils.hasText(article.getTitle())) {
//			return Response.failByParams("title不能为空");
//		}
//		if (!StringUtils.hasText(article.getContent())) {
//			return Response.failByParams("content不能为空");
//		}
//		if (CollectionUtils.isEmpty(article.getTags())) {
//			return Response.failByParams("tags不能为空");
//		}
//		if (article.getUserId() == null) {
//			return Response.failByParams("userId不能为空");
//		}
		String id = articleService.saveArticle(article);
		return Response.ok(id);
	}

	@ApiOperation(value = "查询文章信息")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK", response = ArticleDto.class) })
	@GetMapping("/get")
	public ResponseData<ArticleDto> getArticle(String id) {
		String uid = request.getHeader("uid");
		System.err.println(Thread.currentThread().getName() + "\t****" + "\t" + uid);
		if (id == null) {
			return Response.failByParams("文章id不能为空");
		}
		return Response.ok(articleService.getArticle(id));
	}

	@ApiOperation(value = "删除文章")
	@PostMapping("/delete")
	public ResponseData<Boolean> deleteArticle(String id) {
		return Response.ok(articleService.deleteArticle(id));
	}

	@ApiOperation(value = "修改文章")
	@PostMapping("/update")
	public ResponseData<Boolean> updateArticle(@RequestBody Article article) {
		if (article == null) {
			return Response.failByParams("参数不能为空");
		}
		if (!StringUtils.hasText(article.getId())) {
			return Response.failByParams("id不能为空");
		}
		if (!StringUtils.hasText(article.getTitle())) {
			return Response.failByParams("title不能为空");
		}
		if (!StringUtils.hasText(article.getContent())) {
			return Response.failByParams("content不能为空");
		}
		if (CollectionUtils.isEmpty(article.getTags())) {
			return Response.failByParams("tags不能为空");
		}
		if (article.getUserId() == null) {
			return Response.failByParams("userId不能为空");
		}
		return Response.ok(articleService.updateArticle(article));
	}

	@ApiOperation(value = "查询用户的文章信息")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK", response = ArticleDto.class) })
	@GetMapping("/list/user")
	public ResponseData<List<ArticleDto>> queryArticleByUser(Long userId) {
		if (userId == null) {
			// throw new ParamException("userId不能为空");
			return Response.failByParams("userId不能为空");
		}
		return Response.ok(articleService.queryArticleByUser(userId));
	}

	@ApiOperation(value = "增加文章浏览量")
	@GetMapping("/visit/add")
	public ResponseData<Long> addArticleVisitCount(String id) {
		if (id == null) {
			return Response.failByParams("文章id不能为空");
		}
		return Response.ok(articleService.addArticleVisitCount(id));
	}

	@GetMapping("/send")
	public String send() {
		RestTemplate restTemplate = new RestTemplate();

		ExecutorService executorService = Executors.newFixedThreadPool(10);

		List<Integer> datas = new ArrayList<>();

		for (int i = 0; i < 20; i++) {
			executorService.execute(new Runnable() {

				@Override
				public void run() {
					int random = new Random().nextInt(100);
					datas.add(random);
					MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
					HttpHeaders header = new HttpHeaders();
					header.add("token",  JWTUtils.getInstance().getToken(random+"", 60));
					
					HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(map, header);
					restTemplate.exchange("http://192.168.31.244:2011/monkey-article-service/article/get?id=" + random,
							HttpMethod.GET, httpEntity, String.class);
				}
			});
		}
		executorService.shutdown();
		try {
			executorService.awaitTermination(1, TimeUnit.HOURS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Collections.sort(datas, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		});
		System.out.println(datas.toString());
		return "success";
	}
}
