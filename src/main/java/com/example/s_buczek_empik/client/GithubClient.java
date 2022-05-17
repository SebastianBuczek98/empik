package com.example.s_buczek_empik.client;

import com.example.s_buczek_empik.model.dto.GithubUserDto;

/**
 * ----------------------------
 * Created by Sebastian Buczek
 * ----------------------------
 */

public interface GithubClient {

    GithubUserDto getGithubUserData(String login);

}
