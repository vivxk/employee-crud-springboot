package com.backend.employee.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket swagconfig() {

		return new Docket(DocumentationType.SWAGGER_2).apiInfo(getInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.backend.employee.controller"))
				.apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();
	}

	private ApiInfo getInfo() {
		ApiInfo apiInfo = new ApiInfo("Employee", "Employee CRUD Application", "Version: 1.0", "ToS",
				new Contact("Vivek Sankhla", "https://github.com/vivxk/", "@"), "https://unlicense.org",
				"https://example.com", Collections.emptyList());
		return apiInfo;
	}
}
