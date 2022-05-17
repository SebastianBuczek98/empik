package com.example.s_buczek_empik.service;

import com.example.s_buczek_empik.client.GithubClient;
import com.example.s_buczek_empik.model.dto.GithubUserDto;
import com.example.s_buczek_empik.model.dto.UserDataDto;
import com.example.s_buczek_empik.repository.RequestCountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import static com.example.s_buczek_empik.service.UserDataFactory.toUserDataDtoWithoutCalculations;

/**
 * ----------------------------
 * Created by Sebastian Buczek
 * ----------------------------
 */

@Component
@AllArgsConstructor
public class UsersService {

    private final GithubClient githubClient;

    public UserDataDto getUserData(String login){
        login = login.strip();
        GithubUserDto githubUserDto = githubClient.getGithubUserData(login);

        UserDataDto userDataDto = toUserDataDtoWithoutCalculations(githubUserDto);
        userDataDto.setCalculations(processUserCalculations(githubUserDto));
        return userDataDto;
    }

    private String processUserCalculations(GithubUserDto githubUserDto) {
        double result;
        int followers = githubUserDto.getFollowers() != null ? githubUserDto.getFollowers() : 0;
        int public_repos = githubUserDto.getPublic_repos() != null ? githubUserDto.getPublic_repos() : 0;

        if(followers != 0) {
            result = 6 / (followers * (2.0 + public_repos));
            return String.valueOf(result);
        } else return "0";
    }


}
