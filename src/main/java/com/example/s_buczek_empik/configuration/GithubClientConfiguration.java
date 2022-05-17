package com.example.s_buczek_empik.configuration;

import com.example.s_buczek_empik.client.GithubClient;
import com.example.s_buczek_empik.model.dto.GithubUserDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

/**
 * ----------------------------
 * Created by Sebastian Buczek
 * ----------------------------
 */

@Component
public class GithubClientConfiguration {

    @Value("${github-users-api.rest-template.url}")
    private String url;

    @Value("${github-users-api.rest-template.timeout}")
    private Long timeout;

    @Bean(name = "githubClientRestTemplate")
    RestTemplate restTemplate() {
        return new RestTemplateBuilder()
                .rootUri(url)
                .setConnectTimeout(Duration.ofSeconds(timeout))
                .build();
    }

}
