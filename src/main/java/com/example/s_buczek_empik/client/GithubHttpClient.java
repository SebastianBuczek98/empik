package com.example.s_buczek_empik.client;

import com.example.s_buczek_empik.model.dto.GithubUserDto;
import com.example.s_buczek_empik.model.exception.GithubClientException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * ----------------------------
 * Created by Sebastian Buczek
 * ----------------------------
 */
@Slf4j
@Component
public class GithubHttpClient implements GithubClient {

    private final RestTemplate restTemplate;
    private final static String URL = "/users/{login}";

    public GithubHttpClient(@Qualifier("githubClientRestTemplate") RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public GithubUserDto getGithubUserData(String login) {
        try {
            return restTemplate.getForObject(URL, GithubUserDto.class, login);
        } catch (Exception e) {
            log.error("Error occurred while getting user info from github: " + e.getMessage());
            throw new GithubClientException();
        }
    }
}
