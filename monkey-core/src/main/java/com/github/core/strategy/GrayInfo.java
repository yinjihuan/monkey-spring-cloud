package com.github.core.strategy;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Configuration;

import com.ctrip.framework.apollo.spring.annotation.ApolloJsonValue;

import lombok.Data;

@Data
@Configuration
public class GrayInfo {

	@ApolloJsonValue("${grayVersions:{}}")
	private Map<String, List<String>> grayVersions;
	
	@ApolloJsonValue("${grayIps:{}}")
	private Map<String, List<String>> grayIps;
	
}
