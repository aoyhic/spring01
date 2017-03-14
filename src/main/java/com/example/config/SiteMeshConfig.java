package com.example.config;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SiteMeshConfig {
	
	@Bean
	FilterRegistrationBean siteMeshFilter() {
		FilterRegistrationBean filter = new FilterRegistrationBean();
		filter.setFilter(new ConfigurableSiteMeshFilter() {
			@Override
			protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
				builder.addDecoratorPath("/country/*", "/WEB-INF/decorators/default.jsp"); //이 경로로 데코레이션 할거라는 뜻 . country폴더 밑에 들어오는 모든 파일을 데코레이트와 합치는 것 
				builder.addDecoratorPath("/city/*", "/WEB-INF/decorators/default.jsp");
				builder.addDecoratorPath("/dept/*", "/WEB-INF/decorators/default.jsp");
				builder.addDecoratorPath("/emp/*", "/WEB-INF/decorators/default.jsp");
				builder.addDecoratorPath("/xxx/*", "/WEB-INF/decorators/default.jsp");
			}
		});
//		filter.addUrlPatterns("/*");
		return filter;
	}

}
