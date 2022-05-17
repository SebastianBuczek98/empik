package com.example.s_buczek_empik.service;

import com.example.s_buczek_empik.model.dto.GithubUserDto;
import com.example.s_buczek_empik.model.dto.UserDataDto;

/**
 * ----------------------------
 * Created by Sebastian Buczek
 * ----------------------------
 */

class UserDataFactory {

    public static UserDataDto toUserDataDtoWithoutCalculations(GithubUserDto githubUserDto) {
        return UserDataDto.builder()
                .id(String.valueOf(githubUserDto.getId()))
                .login(githubUserDto.getLogin())
                .name(githubUserDto.getName())
                .type(githubUserDto.getType())
                .avatarUrl(githubUserDto.getAvatar_url())
                .createdAt(githubUserDto.getCreated_at())
                .build();
    }

}
