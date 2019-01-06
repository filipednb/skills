package br.com.skills.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Personal Skills Administrator",
                "Personal project to study backend: Java, CI/CD, Spring Boot, Spring Data, Gradle, Unit Tests and development good pratices",
                "API TOS",
                "Terms of service",
                new Contact("Filipe Tagliacozzi", "http://skills-admin.herokuapp.com", "filipednb@gmail.com"),
                "License of API", "API license URL", Collections.emptyList());
    }
}