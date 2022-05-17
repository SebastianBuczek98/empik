package com.example.s_buczek_empik.web;

import com.example.s_buczek_empik.model.dto.UserDataDto;
import com.example.s_buczek_empik.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * ----------------------------
 * Created by Sebastian Buczek
 * ----------------------------
 */

@RestController()
@AllArgsConstructor
public class UsersController {

    private final UsersService usersService;

    @RequestMapping(
            path = "/users/{login}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<UserDataDto> getUserData(@PathVariable(name = "login") String login) {
        return ResponseEntity.ok(usersService.getUserData(login));
    }

}
