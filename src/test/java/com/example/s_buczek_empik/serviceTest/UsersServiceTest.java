package com.example.s_buczek_empik.serviceTest;

import com.example.s_buczek_empik.client.GithubHttpClient;
import com.example.s_buczek_empik.model.dto.GithubUserDto;
import com.example.s_buczek_empik.model.dto.UserDataDto;
import com.example.s_buczek_empik.service.UsersService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

/**
 * ----------------------------
 * Created by Sebastian Buczek
 * ----------------------------
 */

@SpringBootTest
public class UsersServiceTest {

    private final GithubHttpClient githubHttpClient = Mockito.mock(GithubHttpClient.class);
    private final UsersService usersService = new UsersService(githubHttpClient);

    @Test
    public void shouldCorrectlyBuildUserDataDtoWithCalculations() {
        //given
        String login = "login";
        GithubUserDto githubUserDto = GithubUserDto.builder()
                .id(1)
                .login(login)
                .name("name")
                .type("type")
                .avatar_url("avatar_url")
                .created_at("2011-01-25T18:44:36Z")
                .followers(6)
                .public_repos(0)
                .build();

        //when
        when(githubHttpClient.getGithubUserData(login)).thenReturn(githubUserDto);
        UserDataDto actualUserDataDto = usersService.getUserData(login);
        //then
        assertThat(actualUserDataDto.getId()).isEqualTo(String.valueOf(githubUserDto.getId()));
        assertThat(actualUserDataDto.getLogin()).isEqualTo(githubUserDto.getLogin());
        assertThat(actualUserDataDto.getName()).isEqualTo(githubUserDto.getName());
        assertThat(actualUserDataDto.getType()).isEqualTo(githubUserDto.getType());
        assertThat(actualUserDataDto.getAvatarUrl()).isEqualTo(githubUserDto.getAvatar_url());
        assertThat(actualUserDataDto.getCreatedAt()).isEqualTo(githubUserDto.getCreated_at());
        assertThat(actualUserDataDto.getCalculations()).isEqualTo("0.5");

    }

}
