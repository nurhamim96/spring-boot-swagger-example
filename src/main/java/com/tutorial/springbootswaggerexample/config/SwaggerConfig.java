package com.tutorial.springbootswaggerexample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
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
    public Docket customDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tutorial.springbootswaggerexample"))
                .paths(PathSelectors.regex("/api.*"))
                .build().apiInfo(apiInfo());

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Employee API Example")
                .description("A implementation of an API Gateway for Keyhole Labs Microservice Reference.")
                .contact(new Contact("Ibad Nurhamim", "https://github.com/nurhamim96", "nurhamimibad96@gmail.com"))
                .version("1.0")
                .build();
    }
}