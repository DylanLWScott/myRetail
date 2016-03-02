package com.myretail.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("myretail-product-api")
                .apiInfo(apiInfo())
                .select()
                .paths(productpaths())
                .build();
    }
    
    private Predicate<String> productpaths() {
        return regex("/products.*");
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("myRetail Products API")
                .description("This is a RESTful web service that enables \n" + 
                		"\n" +
                		"\n\n For a more thorough description and details check out: <a href='https://github.com/DylanLWScott/myRetail/blob/master/README.md'>https://github.com/DylanLWScott/myRetail/blob/master/README.md</a>")
                .license("The MIT License (MIT)")
                .licenseUrl("https://github.com/DylanLWScott/myRetail/blob/master/LICENSE")
                .contact("drrscott@hotmail.com")
                .build();
    }
}
