package com.example.s_buczek_empik.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * ----------------------------
 * Created by Sebastian Buczek
 * ----------------------------
 */

@Configuration
@EnableSwagger2
@Slf4j
public class SwaggerConfiguration {

    private final String title;
    private final String description;
    private final String license;
    private final String name;
    private final String url;
    private final String email;
    private final String version;

    public SwaggerConfiguration(@Value("${swagger.api.info.title}") String title,
                                @Value("${swagger.api.info.description}") String description,
                                @Value("${swagger.api.info.license}") String license,
                                @Value("${swagger.api.info.name}") String name,
                                @Value("${swagger.api.info.url}") String url,
                                @Value("${swagger.api.info.email}") String email,
                                @Value("${swagger.api.info.version}") String version) {
        this.title = title;
        this.description = description;
        this.license = license;
        this.name = name;
        this.url = url;
        this.email = email;
        this.version = version;
    }

    @Bean
    public Docket getProductApi() {
        log.debug("Initializing Docket for Swagger");

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.s_buczek_empik"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.getApiInfo());
    }

    private ApiInfo getApiInfo() {
        Contact contact = new Contact(this.name, this.url, this.email);
        return new ApiInfo(this.title, this.description, this.version, null, contact, this.license, this.url, Collections.emptyList());
    }
}
