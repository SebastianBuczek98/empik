package com.example.s_buczek_empik.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ----------------------------
 * Created by Sebastian Buczek
 * ----------------------------
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDataDto {

    private String id;
    private String login;
    private String name;
    private String type;
    private String avatarUrl;
    private String createdAt;
    private String calculations;

}
